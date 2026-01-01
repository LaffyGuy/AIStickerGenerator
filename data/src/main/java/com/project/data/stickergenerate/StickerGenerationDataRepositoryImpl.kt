package com.project.data.stickergenerate

import com.project.core.data.network.networkCall
import com.project.data.StickerGenerationDataRepository
import com.project.data.stickergenerate.entities.GeneratedStickerEntity
import com.project.data.stickergenerate.remote.StickerGenerationApi
import com.project.data.BuildConfig
import com.project.data.stickergenerate.remote.dto.GenerateImageRequestDto


internal class StickerGenerationDataRepositoryImpl(
    private val stickerGenerationApi: StickerGenerationApi
) : StickerGenerationDataRepository {

    override suspend fun generateSticker(prompt: String): GeneratedStickerEntity {
        val response = networkCall {
            stickerGenerationApi.generateSticker(
                auth = "Bearer ${BuildConfig.AI_ACCESS_TOKEN}",
                request = GenerateImageRequestDto(inputs = prompt)
            )
        }

        val bytes = response.body()?.bytes()
            ?: throw IllegalStateException("Empty response body")

        return GeneratedStickerEntity(bytes)

    }
}