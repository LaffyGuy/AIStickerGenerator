package com.project.features.prompts.domain.entities

import com.project.core.essentials.entities.ImageSource

data class PromptSample(
    val id: Long,
    val title: String,
    val promptSample: List<String>,
    val promptsExample: List<String>,
    val imagePath: String
)



