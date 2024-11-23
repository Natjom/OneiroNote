package com.example.oneironote.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DefaultShapes = Shapes() // Si nécessaire, configurez vos formes personnalisées

@Composable
fun OneironoteTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = DefaultShapes, // Ajoutez ceci pour éviter les erreurs de typage
        content = content
    )
}

