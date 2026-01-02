package com.project.features.gallery.domain

import com.project.features.gallery.domain.entities.GallerySticker
import kotlinx.coroutines.flow.Flow

interface GetListStickersUseCase {

    operator fun invoke(): Flow<List<GallerySticker>>

}