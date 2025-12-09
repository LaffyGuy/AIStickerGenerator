package com.project.domain.entities

import com.project.core.essentials.entities.ImageSource
import java.time.ZonedDateTime

data class KeyFeature(
    val id: Long,
    val title: String,
    val description: String,
    val image: ImageSource,
    internal val lastDisplayTime: ZonedDateTime
)
