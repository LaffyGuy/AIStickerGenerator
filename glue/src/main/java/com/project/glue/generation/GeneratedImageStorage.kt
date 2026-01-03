package com.project.glue.generation

interface GeneratedImageStorage {

    suspend fun saveTempImage(bytes: ByteArray): String

}