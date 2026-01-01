package com.project.glue.promptssample.di

import com.project.features.prompts.domain.repositories.DetailsPromptSampleRepository
import com.project.features.prompts.domain.repositories.SamplesRepository
import com.project.glue.promptssample.DetailsPromptRepository
import com.project.glue.promptssample.PromptsSamplesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PromptsSampleModule {

    @Binds
    fun bindPromptsSampleRepository(
        impl: PromptsSamplesRepository
    ): SamplesRepository

    @Binds
    fun bindDetailsPromptsSampleRepository(
        impl: DetailsPromptRepository
    ): DetailsPromptSampleRepository

}