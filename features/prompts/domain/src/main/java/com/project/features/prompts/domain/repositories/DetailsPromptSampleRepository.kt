package com.project.features.prompts.domain.repositories

import com.project.features.prompts.domain.entities.PromptSample

interface DetailsPromptSampleRepository {

    suspend fun getDetailsPromptSample(promptId: Int): PromptSample
}