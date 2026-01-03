package com.project.features.presentation.di

import com.project.features.domain.GenerateStickerUseCase
import com.project.features.domain.usecases.GenerateStickerUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface StickerGenerationModule {

    @Binds
    fun bindGenerationStickerUseCase(
        impl: GenerateStickerUseCaseImpl
    ): GenerateStickerUseCase

}