package com.project.glue.promptssample.mappers

import com.project.data.promptssample.entities.PromptSampleDataEntity
import com.project.features.prompts.domain.entities.PromptSample

fun PromptSampleDataEntity.toPromptSample(): PromptSample {
    return PromptSample(
        id = id,
        title = title,
        promptSample = promptSample,
        promptsExample = promptsExample,
        imagePath = imagePath
    )
}