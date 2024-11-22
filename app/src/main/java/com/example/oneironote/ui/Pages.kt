package com.example.oneironote.ui.Pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text

@Composable
fun Page1(modifier: Modifier = Modifier, colors: ColorScheme) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page 1", fontSize = 32.sp, color = colors.onBackground)
    }
}

@Composable
fun Page2(modifier: Modifier = Modifier, colors: ColorScheme) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page 2", fontSize = 32.sp, color = colors.onBackground)
    }
}

@Composable
fun Page3(modifier: Modifier = Modifier, colors: ColorScheme) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page 3", fontSize = 32.sp, color = colors.onBackground)
    }
}

@Composable
fun Page4(modifier: Modifier = Modifier, colors: ColorScheme) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page 4 : OPTION", fontSize = 32.sp, color = colors.onBackground)
    }
}
