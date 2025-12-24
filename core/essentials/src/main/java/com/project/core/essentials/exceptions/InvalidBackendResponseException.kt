package com.project.core.essentials.exceptions

class InvalidBackendResponseException(
    cause: Throwable
): AppException("Can`t parse server response", cause)