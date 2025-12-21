package com.project.core.data.network.clients

import com.project.core.data.network.createHttpLoggingInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import kotlin.time.Duration

internal fun createDefaultOkHttpClient(
    timeout: Duration,
    interceptor: Interceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .callTimeout(timeout)
        .addInterceptor(interceptor)
        .build()
}