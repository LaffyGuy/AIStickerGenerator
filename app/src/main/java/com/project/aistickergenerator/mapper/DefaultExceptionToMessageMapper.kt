package com.project.aistickergenerator.mapper

import com.project.aistickergenerator.R
import com.project.core.essentials.exceptions.BackendException
import com.project.core.essentials.exceptions.ConnectionException
import com.project.core.essentials.exceptions.ExceptionToMessageMapper
import com.project.core.essentials.exceptions.UnknownException
import com.project.core.essentials.resources.StringResources
import javax.inject.Inject

class DefaultExceptionToMessageMapper @Inject constructor(
    private val stringResources: StringResources
): ExceptionToMessageMapper {

    override fun getLocalizedMessage(exception: Exception): String {
        return when(exception) {
            is UnknownException -> stringResources.getString(R.string.unknown_error_message)
            is ConnectionException -> stringResources.getString(R.string.connection_error_message)
            is BackendException -> stringResources.getString(R.string.backend_error_message, exception.httpCode, exception.backendMessage)
            else -> stringResources.getString(R.string.unknown_error_message)
        }
    }
}