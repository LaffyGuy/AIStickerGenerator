package com.project.features.prompts.presentation.promptsdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.project.features.prompts.domain.DetailsPromptSampleByIdUseCase
import com.project.features.prompts.domain.entities.PromptSample
import com.project.navigation.common.PromptsGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromptsDetailsViewModel @Inject constructor(
    private val detailsPromptSampleByIdUseCase: DetailsPromptSampleByIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _uiState = MutableStateFlow(
        State(
            PromptSample(
                id = -1,
                title = "",
                promptSample = emptyList(),
                promptsExample = emptyList(),
                imagePath = ""
            )
        )
    )
    val uiState: StateFlow<State> = _uiState

    private val args = savedStateHandle.toRoute<PromptsGraph.PromptDetailsRoute>()
    private val promptId = args.promptId

    init {
        viewModelScope.launch {
            val promptDetails = detailsPromptSampleByIdUseCase.invoke(promptId)
            _uiState.update {
                it.copy(
                    promptDetails = promptDetails
                )
            }
        }
    }

}

data class State(
    val promptDetails: PromptSample
)
