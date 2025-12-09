package com.project.domain

import com.project.domain.entities.KeyFeature
import kotlinx.coroutines.flow.Flow

interface ShowKeyFeaturesUseCase {

    operator fun invoke(): Flow<Result>

    sealed class Result {

        data class Show(
            val keyFeatures: List<KeyFeature>
        ): Result()

        data object Skip : Result()
    }

}