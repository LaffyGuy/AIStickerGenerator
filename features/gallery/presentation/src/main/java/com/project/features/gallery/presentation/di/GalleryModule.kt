package com.project.features.gallery.presentation.di

import com.project.features.gallery.domain.GetListStickersUseCase
import com.project.features.gallery.domain.usecases.GetListStickersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface GalleryModule {

    @Binds
    fun bindGetListStickersUseCase(
        impl: GetListStickersUseCaseImpl
    ): GetListStickersUseCase
}