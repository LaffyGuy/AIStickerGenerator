package com.project.data.stickergenerate.entities

data class GeneratedStickerEntity(
    val imageBytes: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GeneratedStickerEntity

        if (!imageBytes.contentEquals(other.imageBytes)) return false

        return true
    }

    override fun hashCode(): Int {
        return imageBytes.contentHashCode()
    }
}
