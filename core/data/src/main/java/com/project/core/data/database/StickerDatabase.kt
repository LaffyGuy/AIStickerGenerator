package com.project.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.core.data.database.dao.PromptSampleDao
import com.project.core.data.database.model.PromptSampleEntity
import com.project.core.data.database.util.PromptSampleTypeConverter

@TypeConverters(PromptSampleTypeConverter::class)
@Database(
    entities = [PromptSampleEntity::class],
    version = 2,
    exportSchema = false
)
abstract class StickerDatabase: RoomDatabase() {
    abstract fun getPromptSampleDao(): PromptSampleDao
}