package com.project.core.data.database.util

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PromptSampleTypeConverter {

    @TypeConverter
    fun fromList(list: List<String>): String = Json.encodeToString(list)

    @TypeConverter
    fun toList(data: String): List<String> =
        if (data.isEmpty()) emptyList()
        else Json.decodeFromString(data)

}