package com.project.features.prompts.presentation.promptsdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.project.features.prompts.domain.DetailsPromptSampleByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PromptsDetailsViewModel @Inject constructor(
    private val detailsPromptSampleByIdUseCase: DetailsPromptSampleByIdUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

       private val args = savedStateHandle.toRoute<>()

}
