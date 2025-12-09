package com.project.data.keyfeatures

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.project.core.essentials.entities.ImageSource
import com.project.data.KeyFeaturesDataRepository
import com.project.data.R
import com.project.data.keyfeatures.entities.KeyFeatureDataEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.time.LocalDateTime
import java.time.Period
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class KeyFeaturesDataRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    @ApplicationContext private val context: Context
) : KeyFeaturesDataRepository {
    override suspend fun getKeyFeatures(): List<KeyFeatureDataEntity> {
        return listOf(
            KeyFeatureDataEntity(
                id = 0L,
                title = context.getString(R.string.feature_sticker_title),
                description = context.getString(R.string.feature_sticker_description),
                image = ImageSource.DrawableRes(resId = R.drawable.feature_sticker)
            ),
            KeyFeatureDataEntity(
                id = 0L,
                title = context.getString(R.string.feature_gallery_title),
                description = context.getString(R.string.feature_gallery_description),
                image = ImageSource.DrawableRes(resId = R.drawable.feature_gallery)
            )
        )
    }

    override suspend fun getDisplayPeriod(): Period {
        return Period.ofDays(30)
    }

    override suspend fun saveLastDisplayTime(keyFeatureId: Long, time: ZonedDateTime) {
        dataStore.edit { preferences ->
            preferences[key(keyFeatureId)] = DateTimeFormatter.ISO_ZONED_DATE_TIME.format(time)
        }
    }

    override suspend fun getLastDisplayTime(keyFeatureId: Long): ZonedDateTime {
        return dataStore.data.map { preferences ->
            preferences[key(keyFeatureId)]?.let {
                ZonedDateTime.parse(preferences[key(keyFeatureId)])
            } ?: ZonedDateTime.of(LocalDateTime.MIN, ZoneOffset.UTC)
        }
            .first()
    }

    private fun key(id: Long): Preferences.Key<String> {
        return stringPreferencesKey("key-feature-display-time-$id")
    }

}