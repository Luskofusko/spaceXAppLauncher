package com.mindera.rocketscience.mapper

import androidx.compose.runtime.Composable
import com.mindera.rocketscience.viewmodel.state.MainUiStateController

@Composable
fun MainUiStateController.ErrorDescription.toUi(): String {
    return when (this) {
        MainUiStateController.ErrorDescription.ErrorGettingCompanyInfo -> "Error getting company info"
        MainUiStateController.ErrorDescription.ErrorGettingAllLaunches -> "Error getting all launches"
    }

}

@Composable
fun List<MainUiStateController.ErrorDescription>.toUi(): List<String> {
    return map { it.toUi() }
}