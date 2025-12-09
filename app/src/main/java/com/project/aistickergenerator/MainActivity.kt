package com.project.aistickergenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.compose.AIStickerGeneratorTheme
import com.project.features.prompts.presentation.promptsdetails.PromptDetailsScreen
import com.project.features.prompts.presentation.promptssample.PromptsScreen
import com.project.navigation.AppNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            AIStickerGeneratorTheme {
//                PromptDetailsScreen()
                AppNavHost(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
