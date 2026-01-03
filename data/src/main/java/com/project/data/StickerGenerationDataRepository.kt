package com.project.data

import com.project.data.stickergenerate.entities.GeneratedStickerDataEntity

interface StickerGenerationDataRepository {

    suspend fun generateSticker(prompt: String): GeneratedStickerDataEntity

}