package com.project.core.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.project.core.data.database.model.PromptSampleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PromptSampleDao {

    @Query("SELECT * FROM prompt_samples")
    fun getAllPromptSamples(): Flow<List<PromptSampleEntity>>

    @Query("SELECT * FROM prompt_samples WHERE id = :id")
    suspend fun getPromptSampleById(id: Long): PromptSampleEntity

}