package com.project.glue.init

import com.project.data.KeyFeaturesDataRepository
import com.project.domain.entities.KeyFeature
import com.project.domain.repositories.KeyFeaturesRepository
import com.project.glue.init.mappers.toFeatureEntity
import java.time.Period
import java.time.ZonedDateTime
import javax.inject.Inject

class InitKeyFeaturesRepository @Inject constructor(
    private val keyFeaturesDataRepository: KeyFeaturesDataRepository
) : KeyFeaturesRepository {

    override suspend fun getKeyFeatures(): List<KeyFeature> {
        return keyFeaturesDataRepository.getKeyFeatures().map {
            it.toFeatureEntity(keyFeaturesDataRepository.getLastDisplayTime(it.id))
        }
    }

    override suspend fun getDisplayPeriod(): Period {
        return keyFeaturesDataRepository.getDisplayPeriod()
    }

    override suspend fun saveDisplayTime(keyFeatures: List<KeyFeature>, time: ZonedDateTime) {
        keyFeaturesDataRepository.saveLastDisplayTime(keyFeatures.first().id, time)
    }
}