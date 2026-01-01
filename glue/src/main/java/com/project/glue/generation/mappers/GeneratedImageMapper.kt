package com.project.glue.generation.mappers

import com.project.data.stickergenerate.entities.GeneratedStickerEntity
import com.project.features.domain.entities.GeneratedImage

fun GeneratedStickerEntity.toGeneratedImage(): GeneratedImage {
    return GeneratedImage(
        imageBytes = imageBytes
    )
}