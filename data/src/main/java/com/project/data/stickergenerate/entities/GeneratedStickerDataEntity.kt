package com.project.data.stickergenerate.entities

data class GeneratedStickerDataEntity(
    val imageBytes: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GeneratedStickerDataEntity

        if (!imageBytes.contentEquals(other.imageBytes)) return false

        return true
    }

    override fun hashCode(): Int {
        return imageBytes.contentHashCode()
    }
}
