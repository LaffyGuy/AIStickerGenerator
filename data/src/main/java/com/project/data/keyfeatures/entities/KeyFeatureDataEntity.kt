package com.project.data.keyfeatures.entities

import com.project.core.essentials.entities.ImageSource

data class KeyFeatureDataEntity(
    val id: Long,
    val title: String,
    val description: String,
    val image: ImageSource
)
