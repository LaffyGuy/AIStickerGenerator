package com.project.data

import com.project.core.essentials.LoadResult
import com.project.data.promptssample.entities.PromptSampleDataEntity
import kotlinx.coroutines.flow.Flow

interface PromptsSampleDataRepository {

    fun getPromptSamples(): Flow<LoadResult<List<PromptSampleDataEntity>>>

}