package com.project.features.domain.repositories

import com.project.features.domain.entities.GeneratedImage

interface GenerateImageRepository {

    suspend fun generateSticker(prompt: String): GeneratedImage
}