package com.example.oneironote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oneironote.ui.theme.OneironoteTheme
import com.example.oneironote.ui.theme.LightColorScheme
import com.example.oneironote.ui.theme.DarkColorScheme
import java.text.SimpleDateFormat
import java.util.*

// Définition de l'activité principale
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OneironoteTheme {
                val currentPage = remember { mutableStateOf("home") }

                // Déterminer si le mode sombre est activé
                val darkTheme = isSystemInDarkTheme()

                // Choisir le jeu de couleurs
                val colors = if (darkTheme) DarkColorScheme else LightColorScheme

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(currentPage = currentPage, colors = colors)
                    }
                ) { innerPadding ->
                    when (currentPage.value) {
                        "home" -> HomePage(modifier = Modifier.padding(innerPadding), colors = colors)
                        "page1" -> Page1(modifier = Modifier.padding(innerPadding), colors = colors)
                        "page2" -> Page2(modifier = Modifier.padding(innerPadding), colors = colors)
                        "page3" -> Page3(modifier = Modifier.padding(innerPadding), colors = colors)
                        "page4" -> Page4(modifier = Modifier.padding(innerPadding), colors = colors)
                    }
                }
            }
        }
    }
}

@Composable
fun HomePage(modifier: Modifier = Modifier, colors: ColorScheme) {
    var currentTime by remember { mutableStateOf(getCurrentTime()) }

    // Coroutine pour actualiser l'heure chaque seconde
    LaunchedEffect(Unit) {
        while (true) {
            currentTime = getCurrentTime()
            kotlinx.coroutines.delay(100) // Attendre une seconde
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = currentTime, // Afficher l'heure mise à jour
            fontSize = 48.sp,  // Augmenté pour meilleure visibilité
            color = colors.onBackground
        )
    }
}


// Composant pour Page1
@Composable
fun Page1(modifier: Modifier = Modifier, colors: ColorScheme) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page 1", fontSize = 32.sp, color = colors.onBackground)
    }
}

// Composant pour Page2
@Composable
fun Page2(modifier: Modifier = Modifier, colors: ColorScheme) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page 2", fontSize = 32.sp, color = colors.onBackground)
    }
}

// Composant pour Page3
@Composable
fun Page3(modifier: Modifier = Modifier, colors: ColorScheme) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page 3", fontSize = 32.sp, color = colors.onBackground)
    }
}

// Composant pour Page4
@Composable
fun Page4(modifier: Modifier = Modifier, colors: ColorScheme) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page 4 : OPTION", fontSize = 32.sp, color = colors.onBackground)
    }
}

// Barre de navigation en bas
@Composable
fun BottomNavigationBar(currentPage: MutableState<String>, colors: ColorScheme) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        containerColor = colors.primary
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Bouton gauche 1
            NavigationButton(
                label = "L1",
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)),
                onClick = { currentPage.value = "page1" }
            )

            // Bouton gauche 2
            NavigationButton(
                label = "L2",
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)),
                onClick = { currentPage.value = "page2" }
            )

            // Bouton central "Home"
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(colors.primary, shape = RoundedCornerShape(32.dp))
                    .clickable { currentPage.value = "home" },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Home",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

            // Bouton droit 2
            NavigationButton(
                label = "R2",
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)),
                onClick = { currentPage.value = "page3" }
            )

            // Bouton droit 1
            NavigationButton(
                label = "R1",
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)),
                onClick = { currentPage.value = "page4" }
            )
        }
    }
}

// Bouton de navigation générique
@Composable
fun NavigationButton(label: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(text = label, color = Color.White)
    }
}

// Fonction pour obtenir l'heure actuelle
fun getCurrentTime(): String {
    val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return sdf.format(Date())
}

// Prévisualisation
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OneironoteTheme {
        HomePage(modifier = Modifier.padding(16.dp), colors = LightColorScheme)
    }
}
