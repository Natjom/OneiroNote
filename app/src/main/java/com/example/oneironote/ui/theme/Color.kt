package com.example.oneironote.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.*

// Couleurs principales pour le thème clair
val dreamBlue = Color(0xFFB3E5FC) // Bleu doux pastel
val dreamLavender = Color(0xFFE1BEE7) // Lavande pastel
val dreamPink = Color(0xFFF8BBD0) // Rose pâle
val lightBackground = Color(0xFFFDFDFD) // Blanc cassé

// Couleurs principales pour le thème sombre
val nightBlue = Color(0xFF1A237E) // Bleu nuit
val nightPurple = Color(0xFF4A148C) // Violet profond
val starryGray = Color(0xFF424242) // Gris doux
val darkBackground = Color(0xFF121212) // Noir doux

// Thème clair
val LightColorScheme = lightColorScheme(
    primary = dreamBlue,
    onPrimary = Color(0xFF01579B), // Bleu un peu plus sombre
    primaryContainer = dreamLavender,
    onPrimaryContainer = Color(0xFF6A1B9A), // Violet légèrement plus sombre
    inversePrimary = dreamPink,
    secondary = dreamPink,
    onSecondary = Color(0xFF880E4F), // Rose foncé
    secondaryContainer = dreamLavender,
    onSecondaryContainer = Color(0xFF4A148C),
    tertiary = Color(0xFFA5D6A7), // Vert doux pastel
    onTertiary = Color(0xFF2E7D32),
    tertiaryContainer = Color(0xFFC8E6C9),
    onTertiaryContainer = Color(0xFF1B5E20),
    background = lightBackground,
    onBackground = Color(0xFF212121), // Noir doux
    surface = lightBackground,
    onSurface = Color(0xFF424242), // Gris foncé
    surfaceVariant = Color(0xFFF5F5F5), // Gris clair
    onSurfaceVariant = Color(0xFF757575),
    surfaceTint = dreamBlue,
    inverseSurface = Color(0xFF121212),
    inverseOnSurface = Color(0xFFE0E0E0),
    error = Color(0xFFD32F2F), // Rouge pastel
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFCDD2), // Rouge clair
    onErrorContainer = Color(0xFFB71C1C),
    outline = Color(0xFFBDBDBD),
    outlineVariant = Color(0xFF9E9E9E),
    scrim = Color(0x55000000)
)

// Thème sombre
val DarkColorScheme = darkColorScheme(
    primary = nightBlue,
    onPrimary = Color(0xFF90CAF9), // Bleu clair
    primaryContainer = nightPurple,
    onPrimaryContainer = dreamLavender,
    inversePrimary = Color(0xFFB3E5FC), // Bleu pastel
    secondary = nightPurple,
    onSecondary = Color(0xFFE1BEE7), // Lavande pastel
    secondaryContainer = dreamBlue,
    onSecondaryContainer = nightBlue,
    tertiary = Color(0xFF2E7D32), // Vert foncé apaisant
    onTertiary = Color(0xFFA5D6A7),
    tertiaryContainer = Color(0xFF388E3C),
    onTertiaryContainer = Color(0xFFC8E6C9),
    background = darkBackground,
    onBackground = Color(0xFFE0E0E0), // Blanc cassé
    surface = Color(0xFF1E1E1E), // Noir un peu plus doux que le fond
    onSurface = Color(0xFFBDBDBD), // Gris clair
    surfaceVariant = Color(0xFF303030), // Gris foncé
    onSurfaceVariant = Color(0xFF9E9E9E),
    surfaceTint = nightBlue,
    inverseSurface = lightBackground,
    inverseOnSurface = Color(0xFF121212),
    error = Color(0xFFCF6679), // Rouge doux pour sombre
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFB00020),
    onErrorContainer = Color(0xFFFFDAD4),
    outline = Color(0xFF757575),
    outlineVariant = Color(0xFF616161),
    scrim = Color(0x55000000)
)
