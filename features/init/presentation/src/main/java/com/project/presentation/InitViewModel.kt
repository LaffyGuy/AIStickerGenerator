package com.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.core.essentials.LoadResult
import com.project.core.essentials.exceptions.ExceptionToMessageMapper
import com.project.core.essentials.handler.ExceptionHandler
import com.project.domain.ShowKeyFeaturesUseCase
import com.project.domain.entities.KeyFeature
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor(
    private val showKeyFeaturesUseCase: ShowKeyFeaturesUseCase,
    val exceptionToMessageMapper: ExceptionToMessageMapper,
    private val exceptionHandler: ExceptionHandler,
) : ViewModel() {

    private val _effects = MutableStateFlow(Effects())
    val effects: StateFlow<Effects> = _effects

    val stateFlow: StateFlow<LoadResult<State>> = flow {
        emit(LoadResult.Loading)
        try {
            showKeyFeaturesUseCase().collect { typeResult ->
                when(typeResult) {
                    is ShowKeyFeaturesUseCase.Result.Show -> emit(LoadResult.Success(State(typeResult.keyFeatures)))
                    ShowKeyFeaturesUseCase.Result.Skip -> letsGo()
                }

            }
        }catch (e: Exception) {
            emit(LoadResult.Error(e))
        }
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(1000),
            initialValue = LoadResult.Loading
        )



    fun letsGo() {
        _effects.update { it.copy(launchMainScreen = Unit) }
    }

    fun onLaunchMainScreenProcessed() {
        _effects.update { it.copy(launchMainScreen = null) }
    }

}

data class State(
    val keyFeatures: List<KeyFeature> = emptyList()
)

data class Effects(
    val launchMainScreen: Unit? = null,
)
