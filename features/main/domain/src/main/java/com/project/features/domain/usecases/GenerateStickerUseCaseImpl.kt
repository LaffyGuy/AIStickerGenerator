package com.project.features.domain.usecases

import com.project.core.essentials.logger.Logger
import com.project.features.domain.GenerateStickerUseCase
import com.project.features.domain.entities.GeneratedImage
import com.project.features.domain.repositories.StickerGenerationRepository
import javax.inject.Inject

class GenerateStickerUseCaseImpl @Inject constructor(
    private val stickerGenerationRepository: StickerGenerationRepository
): GenerateStickerUseCase {
    override suspend fun invoke(prompt: String): GeneratedImage {
        Logger.d("AAAA, Sticker - ${stickerGenerationRepository.generateSticker(prompt)}")
        return stickerGenerationRepository.generateSticker(prompt)
    }
}