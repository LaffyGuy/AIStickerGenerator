package com.project.glue.init.mappers

import com.project.data.keyfeatures.entities.KeyFeatureDataEntity
import com.project.domain.entities.KeyFeature
import java.time.ZonedDateTime

fun KeyFeatureDataEntity.toFeatureEntity(
    lastDisplayTime: ZonedDateTime
): KeyFeature {
    return KeyFeature(
        id = id,
        title = title,
        description = description,
        image = image,
        lastDisplayTime = lastDisplayTime
    )
}