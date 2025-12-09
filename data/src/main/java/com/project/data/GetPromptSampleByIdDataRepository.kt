package com.project.data

import com.project.data.promptssample.entities.PromptSampleDataEntity

interface GetPromptSampleByIdDataRepository {

    suspend fun getPromptSampleById(id: Int): PromptSampleDataEntity

}