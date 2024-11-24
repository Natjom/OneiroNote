package com.example.oneironote.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.material3.ColorScheme
import com.example.oneironote.utils.getCurrentTime
import kotlinx.coroutines.delay

@Composable
fun HomePage(modifier: Modifier = Modifier, colors: ColorScheme) {
    var currentTime by remember { mutableStateOf(getCurrentTime()) }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = getCurrentTime()
            delay(100) // Correction : 1 seconde
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = currentTime,
            fontSize = 48.sp,
            color = colors.onBackground
        )
    }
}
