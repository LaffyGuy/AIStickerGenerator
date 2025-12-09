package com.project.features.prompts.domain

import com.project.core.essentials.LoadResult
import com.project.features.prompts.domain.entities.PromptSample
import kotlinx.coroutines.flow.Flow

interface PromptsSampleUseCase {

    fun getPromptsSample(): Flow<LoadResult<List<PromptSample>>>

}