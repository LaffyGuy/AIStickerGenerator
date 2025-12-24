package com.project.data.stickergenerate.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ParametersDto(
    val negativePrompt: String? = null,
    val numInferenceSteps: Int = 30,
    val guidanceScale: Float = 7.5f
)
