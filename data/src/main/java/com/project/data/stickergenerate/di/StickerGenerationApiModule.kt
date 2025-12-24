package com.project.data.stickergenerate.di

import com.project.data.stickergenerate.remote.StickerGenerationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object StickerGenerationApiModule {


    @Provides
    @Singleton
    fun provideStickerGenerationApi(retrofit: Retrofit): StickerGenerationApi {
        return retrofit.create()
    }
}