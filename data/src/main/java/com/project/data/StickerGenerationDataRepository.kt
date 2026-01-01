package com.project.data

import com.project.data.stickergenerate.entities.GeneratedStickerEntity

interface StickerGenerationDataRepository {

    suspend fun generateSticker(prompt: String): GeneratedStickerEntity

}