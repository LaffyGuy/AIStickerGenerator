package com.project.data.promptssample.di

import com.project.data.GetPromptSampleByIdDataRepository
import com.project.data.PromptsSampleDataRepository
import com.project.data.promptssample.GetPromptSampleByIdDataRepositoryImpl
import com.project.data.promptssample.PromptsSampleDataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PromptsSampleModule {

    @Binds
    fun bindPromptsSampleDataRepository(
        impl: PromptsSampleDataRepositoryImpl
    ): PromptsSampleDataRepository

    @Binds
    fun bindGetPromptSampleByIdRepository(
        impl: GetPromptSampleByIdDataRepositoryImpl
    ): GetPromptSampleByIdDataRepository

}