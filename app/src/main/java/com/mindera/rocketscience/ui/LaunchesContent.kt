package com.mindera.rocketscience.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mindera.rocketscience.viewmodel.DashboardView

@Composable
fun LaunchesContent(viewModel: DashboardView) {
    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxWidth()) {
        LazyColumn {
            itemsIndexed(
                viewModel.filteredAllLaunches.value
            ) { index, item ->
                LaunchContent(item, index)
            }
        }
    }
}