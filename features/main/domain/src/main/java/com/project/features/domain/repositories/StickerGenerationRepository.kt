package com.project.features.domain.repositories

import com.project.features.domain.entities.GeneratedImage

interface StickerGenerationRepository {

    suspend fun generateSticker(prompt: String): GeneratedImage
}