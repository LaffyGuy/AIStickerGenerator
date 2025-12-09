package com.project.features.prompts.domain.usecases

import com.project.core.essentials.LoadResult
import com.project.features.prompts.domain.PromptsSampleUseCase
import com.project.features.prompts.domain.entities.PromptSample
import com.project.features.prompts.domain.repositories.SamplesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PromptsSampleUseCaseImpl @Inject constructor(
    private val promptSampleRepository: SamplesRepository
): PromptsSampleUseCase {

    override fun getPromptsSample(): Flow<LoadResult<List<PromptSample>>> {
        return promptSampleRepository.getPromptsSample()
    }
}