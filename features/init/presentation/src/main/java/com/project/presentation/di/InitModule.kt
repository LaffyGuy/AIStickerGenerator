package com.project.presentation.di

import com.project.domain.ShowKeyFeaturesUseCase
import com.project.domain.usecases.ShowKeyFeaturesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface InitModule {

    @Binds
    fun bindShowKeyFeatureUseCase(
        impl: ShowKeyFeaturesUseCaseImpl
    ): ShowKeyFeaturesUseCase
}