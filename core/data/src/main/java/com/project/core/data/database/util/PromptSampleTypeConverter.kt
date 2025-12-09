package com.project.core.data.database.util

import androidx.room.TypeConverter

class PromptSampleTypeConverter {

    @TypeConverter
    fun fromList(list: List<String>): String {
        return list.joinToString("||")
    }

    @TypeConverter
    fun toList(data: String): List<String> {
        return data.split("||")
    }

}