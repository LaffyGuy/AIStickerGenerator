package com.project.core.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prompt_samples")
data class PromptSampleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val promptSample: List<String>,
    val promptsExample: List<String>,
    val imagePath: String
)


