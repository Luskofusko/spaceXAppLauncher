package com.mindera.rocketscience.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mindera.rocketscience.R
import com.mindera.rocketscience.presentation.theme.SpaceXLauncherTheme

@Composable
fun CompanyHeaderContent() {
    Surface(
        color = Color.DarkGray,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.company).uppercase(),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun CompanyHeaderContentPreview() {
    SpaceXLauncherTheme {
        CompanyHeaderContent()
    }
}
