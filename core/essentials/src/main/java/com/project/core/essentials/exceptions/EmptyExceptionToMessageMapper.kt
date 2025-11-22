package com.project.core.essentials.exceptions

class EmptyExceptionToMessageMapper: ExceptionToMessageMapper {
    override fun getLocalizedMessage(exception: Exception): String {
        return exception.message ?: "An error occurred."
    }
}