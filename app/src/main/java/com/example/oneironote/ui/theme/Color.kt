package com.example.oneironote.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.*

// Définir les couleurs principales
val lightBlue = Color(0xFF81D4FA)
val darkBlue = Color(0xFF0288D1)
val lightPurple = Color(0xFFCE93D8)
val darkPurple = Color(0xFF7B1FA2)
val white = Color(0xFFFFFFFF)
val black = Color(0xFF000000)

// Thème clair
val LightColorScheme = lightColorScheme(
    primary = lightBlue,
    onPrimary = darkBlue,
    primaryContainer = lightPurple,
    onPrimaryContainer = darkPurple,
    inversePrimary = darkPurple,
    secondary = lightPurple,
    onSecondary = darkPurple,
    secondaryContainer = darkBlue,
    onSecondaryContainer = lightBlue,
    tertiary = Color(0xFF4CAF50), // Ajoute des couleurs supplémentaires si nécessaire
    onTertiary = Color(0xFF2C6E2F),
    tertiaryContainer = Color(0xFF81C784),
    onTertiaryContainer = Color(0xFF1B5E20),
    background = white,
    onBackground = black,
    surface = white,
    onSurface = black,
    surfaceVariant = Color(0xFFF5F5F5),
    onSurfaceVariant = Color(0xFF3E3E3E),
    surfaceTint = lightBlue,
    inverseSurface = Color(0xFF121212),
    inverseOnSurface = Color(0xFFE0E0E0),
    error = Color(0xFFB00020),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD4),
    onErrorContainer = Color(0xFF410002),
    outline = Color(0xFFBDBDBD),
    outlineVariant = Color(0xFF9E9E9E),
    scrim = Color(0x55000000)
)

// Thème sombre
val DarkColorScheme = darkColorScheme(
    primary = darkBlue,
    onPrimary = lightBlue,
    primaryContainer = darkPurple,
    onPrimaryContainer = lightPurple,
    inversePrimary = lightPurple,
    secondary = darkPurple,
    onSecondary = lightBlue,
    secondaryContainer = lightBlue,
    onSecondaryContainer = darkBlue,
    tertiary = Color(0xFF4CAF50),
    onTertiary = Color(0xFF2C6E2F),
    tertiaryContainer = Color(0xFF81C784),
    onTertiaryContainer = Color(0xFF1B5E20),
    background = black,
    onBackground = white,
    surface = Color(0xFF121212),
    onSurface = white,
    surfaceVariant = Color(0xFF303030),
    onSurfaceVariant = Color(0xFFBDBDBD),
    surfaceTint = darkBlue,
    inverseSurface = white,
    inverseOnSurface = Color(0xFF121212),
    error = Color(0xFFB00020),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD4),
    onErrorContainer = Color(0xFF410002),
    outline = Color(0xFF757575),
    outlineVariant = Color(0xFF616161),
    scrim = Color(0x55000000)
)
