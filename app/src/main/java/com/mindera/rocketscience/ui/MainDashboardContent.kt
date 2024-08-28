package com.mindera.rocketscience.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mindera.rocketscience.R
import com.mindera.rocketscience.mapper.toUi
import com.mindera.rocketscience.viewmodel.DashboardView
import com.mindera.rocketscience.viewmodel.state.MainUiStateController.UiState

@Composable
fun MainContent(viewModel: DashboardView, modifier: Modifier = Modifier) {
    val uiState by viewModel.mainUiStateController

    Column(modifier = modifier) {
        CompanyHeaderContent()
        CompanyInfoContent(viewModel)
        LaunchesHeaderContent()
        LaunchesContent(viewModel)
    }

    onUiState(uiState, viewModel)

}

@Composable
fun onUiState(uiState: UiState, viewModel: DashboardView) {
    if (uiState.showLaunchDetailsDialog) {
        LaunchDetailsDialog(viewModel)
    } else if (uiState.showLaunchesFilters) {
        LaunchesFiltersDialog(viewModel)
    } else if (uiState.errorsDescriptions.isNotEmpty()) {
        ErrorDialog(
           viewModel,
           uiState.errorsDescriptions.toUi().joinToString {it}
        )
    }
}

@Composable
fun sinceOrFrom(days: Long): String {
    return if (days < 0) {
        stringResource(id = R.string.since)
    } else {
        stringResource(id = R.string.from)
    }
}