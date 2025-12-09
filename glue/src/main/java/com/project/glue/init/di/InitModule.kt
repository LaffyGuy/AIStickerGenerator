package com.project.glue.init.di

import com.project.domain.repositories.DateTimeRepository
import com.project.domain.repositories.KeyFeaturesRepository
import com.project.glue.init.InitDateTimeRepository
import com.project.glue.init.InitKeyFeaturesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface InitModule {

    @Binds
    fun bindDateTimeRepository(
        impl: InitDateTimeRepository
    ): DateTimeRepository

    @Binds
    fun bindKeyFeaturesRepository(
        impl: InitKeyFeaturesRepository
    ): KeyFeaturesRepository

}