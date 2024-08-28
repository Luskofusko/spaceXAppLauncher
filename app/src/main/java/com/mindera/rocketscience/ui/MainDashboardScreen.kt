package com.mindera.rocketscience.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mindera.rocketscience.viewmodel.DashboardView
import com.mindera.rocketscience.viewmodel.MainDashboardViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun MainDashboardScreen(viewModel: DashboardView = getViewModel<MainDashboardViewModel>()) {
    Scaffold(
        topBar = { SpaceXTopAppBar(viewModel) },

    ) {
        MainContent(viewModel, modifier = Modifier.padding(it))
    }
}