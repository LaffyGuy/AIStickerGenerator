package com.project.data.promptssample

import com.project.core.data.database.dao.PromptSampleDao
import com.project.data.GetPromptSampleByIdDataRepository
import com.project.data.promptssample.entities.PromptSampleDataEntity
import com.project.data.promptssample.entities.toPromptSampleDataEntity
import javax.inject.Inject

class GetPromptSampleByIdDataRepositoryImpl @Inject constructor(
    private val promptSampleDao: PromptSampleDao
): GetPromptSampleByIdDataRepository {

    override suspend fun getPromptSampleById(id: Int): PromptSampleDataEntity {
        return promptSampleDao.getPromptSampleById(id).toPromptSampleDataEntity()
    }
}