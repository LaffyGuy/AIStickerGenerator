package com.project.glue.generation

import com.project.data.StickerGenerationDataRepository
import com.project.features.domain.entities.GeneratedImage
import com.project.features.domain.repositories.StickerGenerationRepository
import com.project.glue.generation.mappers.toGeneratedImage
import javax.inject.Inject

class GenerationRepository @Inject constructor(private val stickerGenerationDataRepository: StickerGenerationDataRepository): StickerGenerationRepository {
    override suspend fun generateSticker(prompt: String): GeneratedImage {
        return stickerGenerationDataRepository.generateSticker(prompt).toGeneratedImage()
    }
}