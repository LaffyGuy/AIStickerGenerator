package com.project.glue.promptssample.mappers

import com.project.data.GetPromptSampleByIdDataRepository
import com.project.features.prompts.domain.entities.PromptSample
import com.project.features.prompts.domain.repositories.DetailsPromptSampleRepository
import javax.inject.Inject

class DetailsPromptRepository @Inject constructor(
    private val getPromptSampleByIdDataRepository: GetPromptSampleByIdDataRepository
): DetailsPromptSampleRepository {

    override suspend fun getDetailsPromptSample(promptId: Long): PromptSample {
        return getPromptSampleByIdDataRepository.getPromptSampleById(promptId).toPromptSample()
    }
}