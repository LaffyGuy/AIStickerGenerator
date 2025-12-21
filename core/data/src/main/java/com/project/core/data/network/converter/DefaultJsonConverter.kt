package com.project.core.data.network.converter

import kotlinx.serialization.json.Json

internal fun createDefaultJson(isDebug: Boolean): Json {
    return Json {
        if(isDebug) {
            prettyPrint = true
        }
        explicitNulls = false
        encodeDefaults = true
        ignoreUnknownKeys = true
    }
}