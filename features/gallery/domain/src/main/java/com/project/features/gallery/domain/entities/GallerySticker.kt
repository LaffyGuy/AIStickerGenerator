package com.project.features.gallery.domain.entities

import java.time.ZonedDateTime

data class GallerySticker(
    val id: Long,
    val image: Int,
    val date: ZonedDateTime
)
