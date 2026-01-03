package com.project.data.stickergenerate

import com.project.core.data.network.networkCall
import com.project.core.essentials.exceptions.BackendException
import com.project.core.essentials.exceptions.InvalidBackendResponseException
import com.project.data.StickerGenerationDataRepository
import com.project.data.stickergenerate.entities.GeneratedStickerDataEntity
import com.project.data.stickergenerate.remote.StickerGenerationApi
import com.project.data.BuildConfig
import com.project.data.stickergenerate.remote.dto.GenerateImageRequestDto


internal class StickerGenerationDataRepositoryImpl(
    private val stickerGenerationApi: StickerGenerationApi
) : StickerGenerationDataRepository {

    override suspend fun generateSticker(prompt: String): GeneratedStickerDataEntity {
        val response = networkCall {
            stickerGenerationApi.generateSticker(
                auth = "Bearer ${BuildConfig.AI_ACCESS_TOKEN}",
                request = GenerateImageRequestDto(inputs = prompt)
            )
        }

        if (!response.isSuccessful) {
            throw BackendException(
                httpCode = response.code(),
                backendMessage = response.message()
            )
        }

        val body = response.body()
            ?: throw InvalidBackendResponseException()

        return GeneratedStickerDataEntity(body.bytes())
    }

}