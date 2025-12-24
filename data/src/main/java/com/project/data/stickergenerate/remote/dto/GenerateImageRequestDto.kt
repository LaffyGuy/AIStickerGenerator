package com.project.data.stickergenerate.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GenerateImageRequestDto(
    val inputs: String,
    val parameters: ParametersDto? = null
)
