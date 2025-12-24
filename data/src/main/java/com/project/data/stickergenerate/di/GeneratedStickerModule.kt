package com.project.data.stickergenerate.di

import com.project.data.StickerGenerationDataRepository
import com.project.data.stickergenerate.StickerGenerationDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface GeneratedStickerModule {

    @Binds
    fun bindStickerGenerationDataRepository(
        impl: StickerGenerationDataRepositoryImpl
    ): StickerGenerationDataRepository

}