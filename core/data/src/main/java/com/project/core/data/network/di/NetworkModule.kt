package com.project.core.data.network.di

import com.project.core.data.network.NetworkConfig
import com.project.core.data.network.clients.createDefaultOkHttpClient
import com.project.core.data.network.clients.createDefaultRetrofitClient
import com.project.core.data.network.converter.createDefaultJson
import com.project.core.data.network.createHttpLoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideDefaultJson(networkConfig: NetworkConfig): Json {
        return createDefaultJson(networkConfig.isDebug)
    }

    @Provides
    @Singleton
    fun provideOkHttp(networkConfig: NetworkConfig, ): OkHttpClient {
        return createDefaultOkHttpClient(
            networkConfig.timeout,
            interceptor = createHttpLoggingInterceptor(isDebug = networkConfig.isDebug)
        )
    }


    @Provides
    @Singleton
    fun provideRetrofit(
        networkConfig: NetworkConfig,
        client: OkHttpClient,
        json: Json
    ): Retrofit {
        return createDefaultRetrofitClient(
            baseUrl = networkConfig.baseUrl,
            client = client,
            json = json
        )
    }
}