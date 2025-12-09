package com.project.core.data.database.di

import android.content.Context
import androidx.room.Room
import com.project.core.data.database.StickerDatabase
import com.project.core.data.database.dao.PromptSampleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): StickerDatabase {
        return Room.databaseBuilder(
            context,
            StickerDatabase::class.java,
            "sticker.db"
        ).createFromAsset("databases/promptsampledb.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideStickerDao(database: StickerDatabase): PromptSampleDao {
        return database.getPromptSampleDao()
    }

}