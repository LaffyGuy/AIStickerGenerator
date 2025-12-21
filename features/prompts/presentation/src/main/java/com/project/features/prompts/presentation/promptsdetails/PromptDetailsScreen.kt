package com.project.features.prompts.presentation.promptsdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.project.core.essentials.entities.ImageSource
import com.project.core.theme.Dimens
import com.project.core.theme.MediumVerticalSpace
import com.project.core.theme.components.ImageView
import com.project.core.theme.previews.PreviewScreenContent
import com.project.core.theme.previews.ScreenPreview
import com.project.features.prompts.domain.entities.PromptSample
import com.project.features.prompts.presentation.R

@Composable
fun PromptDetailsScreen() {

    val viewModel: PromptsDetailsViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PromptDetailsContent(
        promptSample = uiState.promptDetails
    )
}

@Composable
fun PromptDetailsContent(
    promptSample: PromptSample
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageView(
            imageSources = ImageSource.Local(promptSample.imagePath),
            modifier = Modifier
                .size(365.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )

        )
        MediumVerticalSpace()
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Anime Style",
                    fontSize = Dimens.LargeTextSize,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
                Text(
                    text = promptSample.promptSample.joinToString(separator = "\n") { "• $it" },
                    modifier = Modifier.padding(16.dp)
                )
                HorizontalDivider()
                Text(
                    text = "Example Prompts",
                    fontSize = Dimens.LargeTextSize,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
                MediumVerticalSpace()
                Text(
                    text = promptSample.promptsExample.joinToString(separator = "\n") { "• $it" },
                    modifier = Modifier.padding(
                        start = 16.dp,
                        bottom = 16.dp,
                        top = 8.dp,
                        end = 16.dp
                    )
                )
            }
        }
    }
}

@ScreenPreview
@Composable
fun PromptDetailsContentPreview() {
    PreviewScreenContent {
//        PromptDetailsContent(
//            imageSource = ImageSource.DrawableRes(R.drawable.sticker__1_),
//            promptSample = "• Focus on big expressive eyes and colorful hair" +
//                    "\n• Mention emotions clearly: happy, sad, angry, surprised" +
//                    "\n• Use terms like chibi, kawaii, fantasy, magical" +
//                    "\n• Specify background: city, forest, school, or fantasy world" +
//                    "\n• Include accessories: cat, sword, hat, headphones" +
//                    "\n Example: Combine emotion + action + accessories + background for vivid anime stickers",
//            promptsExample = "• Cute anime girl holding a magical cat, big sparkling eyes, pastel colors, chibi style" +
//                    "\n• Anime boy with headphones, city night background, neon lights, dynamic pose" +
//                    "\n• Anime-style kawaii animal with oversized head and expressive eyes" +
//                    "\n• Specify background: city, forest, school, or fantasy world" +
//                    "\n• Chibi anime sticker of a happy cat eating sushi"
//        )
    }
}