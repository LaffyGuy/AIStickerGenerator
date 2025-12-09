package com.project.aistickergenerator

import com.project.core.common_android.AbstractApplication
import com.project.core.essentials.exceptions.ExceptionToMessageMapper
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App: AbstractApplication() {

    @Inject
    lateinit var exceptionToMessageMapper: ExceptionToMessageMapper

    override fun onCreate() {
        super.onCreate()
        ExceptionToMessageMapper.set(exceptionToMessageMapper)
    }

}