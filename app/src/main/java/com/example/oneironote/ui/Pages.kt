package com.example.oneironote.ui.Pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp

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
fun Page4(
    modifier: Modifier = Modifier,
    colors: ColorScheme,
    switchTheme: (String) -> Unit
) {
    var themeState by remember { mutableStateOf("auto") } // "auto", "light", "dark"

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background), // Correct usage of background
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // To center items horizontally
            verticalArrangement = Arrangement.Center, // To center items vertically
            modifier = Modifier.fillMaxSize() // Ensure column fills the full available space
        ) {
            // Text content
            Text(
                text = "Page 4 : OPTION",
                fontSize = 32.sp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp)) // Adds spacing between text and button

            // Button content
            Button(
                onClick = {
                    themeState = when (themeState) {
                        "auto" -> "light"
                        "light" -> "dark"
                        "dark" -> "auto"
                        else -> "auto"
                    }
                    switchTheme(themeState)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colors.primary,
                    contentColor = colors.onPrimary // Correct dynamic colors for button
                )
            ) {
                Text(
                    text = when (themeState) {
                        "auto" -> "Activer le mode clair"
                        "light" -> "Activer le mode sombre"
                        "dark" -> "Basculer sur automatique"
                        else -> "Changer le thème"
                    }
                )
            }
        }
    }
}
