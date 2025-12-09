package com.project.features.prompts.domain

import com.project.features.prompts.domain.entities.PromptSample

interface DetailsPromptSampleByIdUseCase {

    suspend operator fun invoke(id: Int): PromptSample

}