package com.project.data.promptssample.entities

import com.project.core.data.database.model.PromptSampleEntity

data class PromptSampleDataEntity(
    val id: Long,
    val title: String,
    val promptSample: List<String>,
    val promptsExample: List<String>,
    val imagePath: String
)

fun PromptSampleEntity.toPromptSampleDataEntity(): PromptSampleDataEntity {
    return PromptSampleDataEntity(
        id = id,
        title = title,
        promptSample = promptSample,
        promptsExample = promptsExample,
        imagePath = imagePath
    )
}
