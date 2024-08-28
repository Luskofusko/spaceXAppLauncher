package com.mindera.rocketscience.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mindera.rocketscience.viewmodel.DashboardView

@Composable
fun ErrorDialog(viewModel: DashboardView, errorDescription: String) {
    AlertDialog(
        onDismissRequest = {
            viewModel.onErrorDismiss()
        },
        confirmButton = {
            TextButton(
                onClick = { viewModel.onErrorOkButton() }
            ) {
                Text(text = "OK")
            }
        },
        title = {
            Text(text = "Error retreiving data")
        },
        text = {
            Text(text = errorDescription)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        shape = RoundedCornerShape(6.dp),
        containerColor = Color.White

    )
}