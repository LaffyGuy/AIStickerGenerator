package com.project.features.gallery.domain.repositories

import com.project.features.gallery.domain.entities.GallerySticker
import kotlinx.coroutines.flow.Flow

interface GalleryRepository {

    fun getStickersList(): Flow<List<GallerySticker>>

}