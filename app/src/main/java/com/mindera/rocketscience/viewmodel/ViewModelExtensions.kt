package com.mindera.rocketscience.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State

fun <T> MutableState<T>.asState(): State<T> =
    this