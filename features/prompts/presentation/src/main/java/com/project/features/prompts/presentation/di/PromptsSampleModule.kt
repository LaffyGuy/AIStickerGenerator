package com.project.features.prompts.presentation.di

import com.project.features.prompts.domain.DetailsPromptSampleByIdUseCase
import com.project.features.prompts.domain.PromptsSampleUseCase
import com.project.features.prompts.domain.usecases.DetailsPromptSampleByIdUseCaseImpl
import com.project.features.prompts.domain.usecases.PromptsSampleUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PromptsSampleModule {

    @Binds
    fun bindPromptsSampleUseCase(
        impl: PromptsSampleUseCaseImpl
    ): PromptsSampleUseCase

    @Binds
    fun bindDetailsPromptSampleByIdUseCase(
        impl: DetailsPromptSampleByIdUseCaseImpl
    ): DetailsPromptSampleByIdUseCase

}