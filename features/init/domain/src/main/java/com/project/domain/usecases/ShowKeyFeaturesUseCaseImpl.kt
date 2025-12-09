package com.project.domain.usecases

import com.project.domain.ShowKeyFeaturesUseCase
import com.project.domain.ShowKeyFeaturesUseCase.*
import com.project.domain.entities.KeyFeature
import com.project.domain.repositories.DateTimeRepository
import com.project.domain.repositories.KeyFeaturesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ShowKeyFeaturesUseCaseImpl @Inject constructor(
    private val keyFeaturesRepository: KeyFeaturesRepository,
    private val dateTimeRepository: DateTimeRepository
) : ShowKeyFeaturesUseCase {

    override fun invoke(): Flow<Result> = flow {
        if (shouldShowKeyFeatures()) {
            val keyFeatures = getKeyFeatures()
            emit(Result.Show(keyFeatures))
            saveDisplayTime(keyFeatures)
        } else {
            emit(Result.Skip)
        }
    }

    private suspend fun shouldShowKeyFeatures(): Boolean {
        val period = keyFeaturesRepository.getDisplayPeriod()
        val lastDisplayTime = keyFeaturesRepository.getKeyFeatures().maxOf { it.lastDisplayTime }
        val now = dateTimeRepository.now()
        return lastDisplayTime + period < now
    }

    private suspend fun getKeyFeatures(): List<KeyFeature> {
        return keyFeaturesRepository.getKeyFeatures()
    }

    private suspend fun saveDisplayTime(keyFeatures: List<KeyFeature>) {
        val now = dateTimeRepository.now()
        keyFeaturesRepository.saveDisplayTime(keyFeatures, now)
    }
}