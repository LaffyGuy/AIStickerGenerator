package com.project.data.stickergenerate

import com.project.data.StickerGenerationDataRepository
import com.project.data.stickergenerate.entities.GeneratedStickerEntity
import com.project.data.stickergenerate.remote.StickerGenerationApi
import com.project.data.BuildConfig


internal class StickerGenerationDataRepositoryImpl(
    private val stickerGenerationApi: StickerGenerationApi
): StickerGenerationDataRepository {

    override suspend fun generate(prompt: String): GeneratedStickerEntity {
        val response = stickerGenerationApi.generateSticker(
            auth = "Bearer ${}"
        )
    }
}