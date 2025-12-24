package com.project.core.data.network

import com.project.core.essentials.exceptions.BackendException
import com.project.core.essentials.exceptions.ConnectionException
import com.project.core.essentials.exceptions.InvalidBackendResponseException
import com.project.core.essentials.exceptions.UnknownException
import kotlinx.serialization.SerializationException
import okio.IOException
import retrofit2.HttpException

inline fun <T> networkCall(block: () -> T): T {
    return try {
        block()
    } catch (e: HttpException) {
        val code = e.code()
        val message = e.message()
        throw BackendException(httpCode = code, backendMessage = message, cause = e)
    } catch (e: SerializationException) {
        throw InvalidBackendResponseException(cause = e)
    } catch (e: IOException) {
        throw ConnectionException(cause = e)
    } catch (e: Exception) {
        throw UnknownException(cause = e)
    }
}