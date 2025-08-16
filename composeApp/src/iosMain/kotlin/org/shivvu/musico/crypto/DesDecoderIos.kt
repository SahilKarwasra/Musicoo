package org.shivvu.musico.crypto

import kotlinx.cinterop.*
import platform.CommonCrypto.*

actual fun provideDes(): DesEcbPkcs5 = DesEcbPkcs5CC()

class DesEcbPkcs5CC : DesEcbPkcs5 {
    override fun decrypt(key: ByteArray, data: ByteArray): ByteArray = memScoped {
        require(key.size == kCCKeySizeDES) { "DES key must be 8 bytes" }

        val outputCapacity = data.size + kCCBlockSizeDES // PKCS5/7 worst-case
        val out = ByteArray(outputCapacity)
        val outBytesMoved = alloc<size_tVar>()

        val status = data.usePinned { dataPinned ->
            key.usePinned { keyPinned ->
                out.usePinned { outPinned ->
                    CCCrypt(
                        kCCDecrypt,
                        kCCAlgorithmDES,
                        kCCOptionPKCS7Padding or kCCOptionECBMode,
                        keyPinned.addressOf(0),
                        key.size.toULong(),
                        null, // IV not used in ECB
                        dataPinned.addressOf(0),
                        data.size.toULong(),
                        outPinned.addressOf(0),
                        outputCapacity.toULong(),
                        outBytesMoved.ptr
                    )
                }
            }
        }

        if (status != kCCSuccess) error("DES decryption failed: $status")

        return out.copyOf(outBytesMoved.value.toInt())
    }
}
