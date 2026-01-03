package com.project.glue.generation

import com.project.data.StickerGenerationDataRepository
import com.project.features.domain.entities.GeneratedImage
import com.project.features.domain.repositories.StickerGenerationRepository
import javax.inject.Inject

class GenerationRepository @Inject constructor(
    private val stickerGenerationDataRepository: StickerGenerationDataRepository,
    private val imageStorage: GeneratedImageStorage
)
    : StickerGenerationRepository {
    override suspend fun generateSticker(prompt: String): GeneratedImage {
        val entity = stickerGenerationDataRepository.generateSticker(prompt)
        val path = imageStorage.saveTempImage(entity.imageBytes)

        return GeneratedImage(localPath = path)
    }
}