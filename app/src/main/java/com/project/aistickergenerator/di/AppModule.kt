package com.project.aistickergenerator.di

import com.project.aistickergenerator.mapper.DefaultExceptionToMessageMapper
import com.project.core.essentials.exceptions.ExceptionToMessageMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun bindExceptionToMessageMapper(
        impl: DefaultExceptionToMessageMapper
    ): ExceptionToMessageMapper
}