package com.project.data.promptssample

import com.project.core.data.database.dao.PromptSampleDao
import com.project.core.essentials.LoadResult
import com.project.data.PromptsSampleDataRepository
import com.project.data.promptssample.entities.PromptSampleDataEntity
import com.project.data.promptssample.entities.toPromptSampleDataEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PromptsSampleDataRepositoryImpl @Inject constructor(private val promptDao: PromptSampleDao ): PromptsSampleDataRepository {

    override fun getPromptSamples(): Flow<LoadResult<List<PromptSampleDataEntity>>> {
        return flow {
            emit(LoadResult.Loading)
            try {
                promptDao.getAllPromptSamples().collect { entity ->
                    val dataEntity = entity.map { it.toPromptSampleDataEntity() }
                    emit(LoadResult.Success(dataEntity))
                }
            }catch (e: Exception) {
                emit(LoadResult.Error(e))
            }
        }
    }
}