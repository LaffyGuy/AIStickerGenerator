package com.project.features.prompts.domain.repositories

import com.project.core.essentials.LoadResult
import com.project.features.prompts.domain.entities.PromptSample
import kotlinx.coroutines.flow.Flow

interface SamplesRepository {

    fun getPromptsSample(): Flow<LoadResult<List<PromptSample>>>
}