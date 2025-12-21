package com.project.core.data.network

import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

data class NetworkConfig(
    val baseUrl: String = "https://api-inference.huggingface.co/",
    val timeout: Duration = 10.seconds,
    val isDebug: Boolean = true
)
