package com.mindera.rocketscience

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mindera.rocketscience.presentation.theme.SpaceXLauncherTheme
import com.mindera.rocketscience.ui.MainDashboardScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpaceXLauncherTheme {
                MainDashboardScreen()
            }
        }
    }
}
