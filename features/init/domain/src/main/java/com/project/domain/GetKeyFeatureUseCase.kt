package com.project.domain

import com.project.core.essentials.LoadResult
import com.project.domain.entities.KeyFeature
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetKeyFeatureUseCase @Inject constructor() {
    fun invoke(): Flow<LoadResult<KeyFeature>> {
        return flow {
            delay(2000)
            emit(LoadResult.Success(KeyFeature(1L, "Key Feature Name", "Key Feature Description")))
        }
    }
}