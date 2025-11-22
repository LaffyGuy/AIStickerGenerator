package com.project.core.common_android.di

import com.project.core.common_android.AndroidExceptionHandler
import com.project.core.common_android.AndroidLogger
import com.project.core.common_android.AndroidStringResources
import com.project.core.essentials.handler.ExceptionHandler
import com.project.core.essentials.logger.Logger
import com.project.core.essentials.resources.StringResources
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CommonAndroidModule {

    @Binds
    fun bindLogger(
        impl: AndroidLogger
    ): Logger

    @Binds
    fun bindCoreStringProvider(
        impl: AndroidStringResources
    ): StringResources

    @Binds
    fun bindExceptionHandler(
        impl: AndroidExceptionHandler
    ): ExceptionHandler

}