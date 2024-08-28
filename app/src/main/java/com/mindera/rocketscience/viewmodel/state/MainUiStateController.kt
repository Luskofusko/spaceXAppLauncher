package com.mindera.rocketscience.viewmodel.state

import androidx.compose.runtime.mutableStateOf
import com.mindera.rocketscience.viewmodel.asState

class MainUiStateController {
    private val _uiState = mutableStateOf(UiState())
    val uiState = _uiState.asState()

    fun ready() {
        _uiState.value = _uiState.value.copy(
            showLaunchDetailsDialog = false,
            showLaunchesFilters = false,
            errorsDescriptions = emptyList()
        )
    }

    fun showLaunchDetailsDialog() {
        _uiState.value = _uiState.value.copy(
            showLaunchDetailsDialog = true
        )
    }

    fun showLaunchesFilters() {
        _uiState.value = _uiState.value.copy(
            showLaunchesFilters = true
        )
    }

    fun showErrorGettingCompanyInfo() {
        val errorsList = getPreviousErrorsIfNeeded()

        errorsList.add(ErrorDescription.ErrorGettingCompanyInfo)

        _uiState.value = _uiState.value.copy(
            errorsDescriptions = errorsList
        )
    }

    fun showErrorGettingAllLaunches() {
        val errorsList = getPreviousErrorsIfNeeded()

        errorsList.add(ErrorDescription.ErrorGettingAllLaunches)

        _uiState.value = _uiState.value.copy(
            errorsDescriptions = errorsList
        )
    }

    private fun getPreviousErrorsIfNeeded(): MutableList<ErrorDescription> {
        val errorsList = mutableListOf<ErrorDescription>()
        if (uiState.value.errorsDescriptions.isNotEmpty()) {
            errorsList.addAll(uiState.value.errorsDescriptions)
        }
        return errorsList
    }

    data class UiState(
        val showLaunchDetailsDialog: Boolean = false,
        val showLaunchesFilters: Boolean = false,
        val errorsDescriptions: List<ErrorDescription> = emptyList()
    )

    sealed class ErrorDescription {
        object ErrorGettingCompanyInfo: ErrorDescription()
        object ErrorGettingAllLaunches: ErrorDescription()
    }

}