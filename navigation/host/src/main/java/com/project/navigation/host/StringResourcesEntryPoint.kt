package com.project.navigation.host

import com.project.core.essentials.resources.StringResources
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface StringResourcesEntryPoint {
    fun stringResources(): StringResources
}