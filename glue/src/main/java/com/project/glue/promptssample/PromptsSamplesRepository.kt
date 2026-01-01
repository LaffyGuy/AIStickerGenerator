package com.project.glue.promptssample

import com.project.core.essentials.LoadResult
import com.project.data.PromptsSampleDataRepository
import com.project.features.prompts.domain.entities.PromptSample
import com.project.features.prompts.domain.repositories.SamplesRepository
import com.project.glue.promptssample.mappers.toPromptSample
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PromptsSamplesRepository @Inject constructor(private val promptsSampleDataRepository: PromptsSampleDataRepository):
    SamplesRepository {

    override fun getPromptsSample(): Flow<LoadResult<List<PromptSample>>> {
       return promptsSampleDataRepository.getPromptSamples()
           .map { result ->
               when(result) {
                   LoadResult.Loading -> LoadResult.Loading
                   is LoadResult.Success -> LoadResult.Success(result.data.map { it.toPromptSample() })
                   is LoadResult.Error -> LoadResult.Error(result.exception)
               }
           }
    }
//       return flow {
//           val loadResult = promptsSampleDataRepository.getPromptSamples()
//           loadResult.collect {
//                when (it) {
//                     is LoadResult.Loading -> emit(LoadResult.Loading)
//                     is LoadResult.Success -> {
//                          val promptSamples = it.data.map { dataEntity ->
//                            dataEntity.toPromptSample()
//                          }
//                          emit(LoadResult.Success(promptSamples))
//                     }
//                     is LoadResult.Error -> emit(LoadResult.Error(it.exception))
//                }
//           }
//       }
//
//    }
}