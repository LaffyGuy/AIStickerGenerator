package com.project.features.gallery.domain.usecases

import com.project.features.gallery.domain.GetListStickersUseCase
import com.project.features.gallery.domain.entities.GallerySticker
import com.project.features.gallery.domain.repositories.GalleryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListStickersUseCaseImpl @Inject constructor(private val galleryRepository: GalleryRepository): GetListStickersUseCase {

    override fun invoke(): Flow<List<GallerySticker>> {
        return galleryRepository.getStickersList()
    }
}