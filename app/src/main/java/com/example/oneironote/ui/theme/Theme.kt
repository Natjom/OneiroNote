package com.example.oneironote.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.foundation.isSystemInDarkTheme

@Composable
fun OneironoteTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Choisir le schéma de couleurs en fonction du thème
    val colors = if (isDarkTheme) DarkColorScheme else LightColorScheme

    // Appliquer le thème
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
