package com.project.glue.promptssample.mappers

import com.project.core.essentials.LoadResult
import com.project.data.PromptsSampleDataRepository
import com.project.features.prompts.domain.entities.PromptSample
import com.project.features.prompts.domain.repositories.SamplesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PromptsSamplesRepository @Inject constructor(private val promptsSampleDataRepository: PromptsSampleDataRepository): SamplesRepository {

    override fun getPromptsSample(): Flow<LoadResult<List<PromptSample>>> {
       return flow {
           val loadResult = promptsSampleDataRepository.getPromptSamples()
           loadResult.collect { it ->
                when (it) {
                     is LoadResult.Loading -> emit(LoadResult.Loading)
                     is LoadResult.Success -> {
                          val promptSamples = it.data.map { dataEntity ->
                            dataEntity.toPromptSample()
                          }
                          emit(LoadResult.Success(promptSamples))
                     }
                     is LoadResult.Error -> emit(LoadResult.Error(it.exception))
                }
           }
       }

    }
}