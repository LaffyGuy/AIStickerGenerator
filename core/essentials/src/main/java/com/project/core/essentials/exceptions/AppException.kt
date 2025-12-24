package com.project.core.essentials.exceptions

abstract class AppException(
    message: String,
    cause: Throwable? = null
): Exception(message, cause)

class UnknownException(
    cause: Throwable
): AppException("Unknown exception occurred", cause)

class ConnectionException(
    cause: Throwable? = null
): AppException("Network error", cause)

class BackendException(
    val httpCode: Int = 400,
    val backendMessage: String = "",
    cause: Throwable? = null
): AppException("Server error", cause)