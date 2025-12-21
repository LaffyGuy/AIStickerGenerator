package com.project.features.prompts.domain.usecases

import com.project.features.prompts.domain.DetailsPromptSampleByIdUseCase
import com.project.features.prompts.domain.entities.PromptSample
import com.project.features.prompts.domain.repositories.DetailsPromptSampleRepository
import javax.inject.Inject

class DetailsPromptSampleByIdUseCaseImpl @Inject constructor(
    private val detailsPromptSampleRepository: DetailsPromptSampleRepository
): DetailsPromptSampleByIdUseCase {

    override suspend fun invoke(id: Long): PromptSample {
         return detailsPromptSampleRepository.getDetailsPromptSample(id)
    }

}