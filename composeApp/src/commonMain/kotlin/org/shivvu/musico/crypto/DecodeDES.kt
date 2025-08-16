package org.shivvu.musico.crypto

import okio.ByteString
import okio.ByteString.Companion.decodeBase64

interface DesEcbPkcs5 {
    fun decrypt(key: ByteArray, data: ByteArray): ByteArray
}

class UrlDecryptor(private val crypto: DesEcbPkcs5) {

    fun decodeDES(input: String, kbps320: Boolean, streamQuality: String): String {
        val cleaned = input.replace("\\", "")
        val encrypted: ByteString = cleaned.decodeBase64()
            ?: error("Invalid Base64 input")

        val key = "38346591".encodeToByteArray() // must be exactly 8 bytes for DES
        val decryptedBytes = crypto.decrypt(key, encrypted.toByteArray())
        var decoded = decryptedBytes.decodeToString()

        // Ensure ".mp4" suffix only once
        decoded = Regex("\\.mp4.*").replace(decoded, ".mp4")

        // Force https
        decoded = decoded.replace("http:", "https:")

        // Swap bitrate according to prefs (mirrors your logic)
        decoded = if (streamQuality == "320") {
            if (kbps320) decoded.replace("96.mp4", "$streamQuality.mp4") else decoded
        } else {
            decoded.replace("96.mp4", "$streamQuality.mp4")
        }

        return decoded
    }
}
