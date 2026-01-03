package com.project.glue.generation

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import javax.inject.Inject

class AndroidGeneratedImageStorage @Inject constructor(
    @ApplicationContext private val context: Context
): GeneratedImageStorage {

    override suspend fun saveTempImage(bytes: ByteArray): String {
        val file = File(
            context.cacheDir,
            "generated_${System.currentTimeMillis()}.png"
        )

        file.outputStream().use { it.write(bytes) }

        return file.absolutePath
    }
}
