package com.project.core.common_android

import android.content.Context
import android.widget.Toast
import com.project.core.essentials.exceptions.ExceptionToMessageMapper
import com.project.core.essentials.handler.ExceptionHandler
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AndroidExceptionHandler @Inject constructor(
    private val exceptionToMessageMapper: ExceptionToMessageMapper,
    @ApplicationContext private val context: Context,
) : ExceptionHandler {

    override fun handleException(exception: Exception) {
        val message = exceptionToMessageMapper.getLocalizedMessage(exception)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}