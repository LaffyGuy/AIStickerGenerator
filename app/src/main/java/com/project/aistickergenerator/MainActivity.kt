package com.project.aistickergenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.project.aistickergenerator.ui.theme.AIStickerGeneratorTheme
import com.project.core.essentials.exceptions.ExceptionToMessageMapper
import com.project.core.essentials.exceptions.UnknownException
import com.project.core.essentials.logger.Logger
import com.project.core.essentials.resources.StringResources
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var exceptionToMessageMapper: ExceptionToMessageMapper

    @Inject
    lateinit var stringResources: StringResources

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Logger.d("Hiiiiiii")

        val message = exceptionToMessageMapper.getLocalizedMessage(UnknownException())
        val message2 = stringResources.getString(R.string.connection_error_message)
        Logger.d(message)
        Logger.d(message2)

        enableEdgeToEdge()
        setContent {
            AIStickerGeneratorTheme {

            }
        }
    }
}
