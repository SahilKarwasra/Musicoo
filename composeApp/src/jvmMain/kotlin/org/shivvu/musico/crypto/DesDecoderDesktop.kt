package org.shivvu.musico.crypto

import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec

actual fun provideDes(): DesEcbPkcs5 = DesEcbPkcs5Jce()

class DesEcbPkcs5Jce : DesEcbPkcs5 {
    override fun decrypt(key: ByteArray, data: ByteArray): ByteArray {
        require(key.size == 8) { "DES key must be 8 bytes" }
        val factory = SecretKeyFactory.getInstance("DES")
        val secretKey = factory.generateSecret(DESKeySpec(key))
        val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        return cipher.doFinal(data)
    }
}
