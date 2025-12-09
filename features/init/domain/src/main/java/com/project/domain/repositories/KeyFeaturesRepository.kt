package com.project.domain.repositories

import com.project.domain.entities.KeyFeature
import java.time.Period
import java.time.ZonedDateTime

interface KeyFeaturesRepository {

    suspend fun getKeyFeatures(): List<KeyFeature>

    suspend fun getDisplayPeriod(): Period

    suspend fun saveDisplayTime(keyFeatures: List<KeyFeature>, time: ZonedDateTime)

}