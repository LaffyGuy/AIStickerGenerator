package com.project.data

import com.project.data.stickergenerate.entities.GeneratedStickerEntity

internal interface StickerGenerationDataRepository {

    suspend fun generate(prompt: String): GeneratedStickerEntity

}