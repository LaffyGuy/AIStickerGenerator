package com.project.features.prompts.presentation.promptssample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.project.core.essentials.entities.ImageSource
import com.project.core.theme.Dimens
import com.project.core.theme.components.LoadResultView
import com.project.core.theme.previews.PreviewScreenContent
import com.project.core.theme.previews.ScreenPreview
import com.project.features.prompts.domain.entities.PromptSample
import com.project.features.prompts.presentation.components.PromptItem

private val promptsList = listOf(
     PromptSample(
         id = 1L,
         title = "Translate to French",
         promptSample = listOf(""),
         promptsExample = listOf(""),
         imagePath = ""
     ),
    PromptSample(
        id = 1L,
        title = "Translate to French",
        promptSample = listOf(""),
        promptsExample = listOf(""),
        imagePath = ""
    ),
    PromptSample(
        id = 1L,
        title = "Translate to French",
        promptSample = listOf(""),
        promptsExample = listOf(""),
        imagePath = ""
    ),
    PromptSample(
        id = 1L,
        title = "Translate to French",
        promptSample = listOf(""),
        promptsExample = listOf(""),
        imagePath = ""
    ),
    PromptSample(
        id = 1L,
        title = "Translate to French",
        promptSample = listOf(""),
        promptsExample = listOf(""),
        imagePath = ""
    ),
    PromptSample(
        id = 1L,
        title = "Translate to French",
        promptSample = listOf(""),
        promptsExample = listOf(""),
        imagePath = ""
    ),
    PromptSample(
        id = 1L,
        title = "Translate to French",
        promptSample = listOf(""),
        promptsExample = listOf(""),
        imagePath = ""
    ),
    PromptSample(
        id = 1L,
        title = "Translate to French",
        promptSample = listOf(""),
        promptsExample = listOf(""),
        imagePath = ""
    )

)


@Composable
fun PromptsScreen() {
    val viewModel: PromptsViewModel = hiltViewModel()
    val loadResult by viewModel.promptsSampleFlow.collectAsStateWithLifecycle()
    LoadResultView(
        loadResult = loadResult,
        onTryAgainAction = {},
        exceptionToMessageMapper = viewModel.exceptionToMessageMapper,
        content = {
            PromptsContent(
                promptsList = it
            )
        }
    )

}

@Composable
fun PromptsContent(
    promptsList: List<PromptSample>
) {
    Box(
       modifier = Modifier.fillMaxSize(),
       contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Prompts samples",
                fontSize = Dimens.LargeTextSize,
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(2.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                items(promptsList) { promptSample ->
                      PromptItem(
                          title = promptSample.title,
                          image = ImageSource.Local(path = promptSample.imagePath)
                      )
                }
            }

        }
    }

}


@ScreenPreview
@Composable
fun PromptsContentPreview() {
    PreviewScreenContent {
        PromptsContent(
           promptsList = promptsList
        )
    }
}