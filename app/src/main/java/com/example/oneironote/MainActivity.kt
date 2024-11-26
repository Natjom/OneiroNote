package com.example.oneironote

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.oneironote.ui.*
import com.example.oneironote.ui.theme.DarkColorScheme
import com.example.oneironote.ui.theme.LightColorScheme
import com.example.oneironote.ui.theme.OneironoteTheme
import androidx.compose.material3.*
import androidx.compose.ui.platform.LocalContext
import com.example.oneironote.utils.getCurrentTime
import com.example.oneironote.utils.loadAlarms
import com.example.oneironote.utils.saveAlarms
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var themeMode by remember { mutableStateOf("auto") }
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() } // Un état global pour les snackbars
    val coroutineScope = rememberCoroutineScope()
    var alarmList by remember { mutableStateOf(loadAlarms(context).toMutableStateList()) }

    // Thème dynamique
    OneironoteTheme(darkTheme = when (themeMode) {
        "light" -> false
        "dark" -> true
        else -> isSystemInDarkTheme()
    }) {
        val currentPage = remember { mutableStateOf("home") }

        val colors = if (themeMode == "dark" || (isSystemInDarkTheme() && themeMode != "light")) {
            DarkColorScheme
        } else {
            LightColorScheme
        }

        // Vérification globale des alarmes
        LaunchedEffect(alarmList) {
            while (true) {
                delay(100) // Vérifie toutes les secondes
                val currentTime = getCurrentTime().substring(0, 5) // Format HH:mm

                // Copie de la liste pour éviter la modification pendant l'itération
                val alarmsToRemove = mutableListOf<String>()

                for (alarm in alarmList) {
                    if (alarm == currentTime) {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Il est $currentTime ! 🎉")
                        }
                        alarmsToRemove.add(alarm) // Marque l'alarme pour suppression
                    }
                }

                // Supprime les alarmes déjà affichées
                if (alarmsToRemove.isNotEmpty()) {
                    alarmList.removeAll(alarmsToRemove)
                    saveAlarms(context, alarmList) // Sauvegarde la liste mise à jour
                }
            }
        }


        Scaffold(
            bottomBar = {
                BottomNavigationBar(currentPage = currentPage, colors = colors)
            },
            snackbarHost = { SnackbarHost(snackbarHostState) } // Host global
        ) { innerPadding ->
            when (currentPage.value) {
                "home" -> HomePage(modifier = Modifier.padding(innerPadding), colors = colors)
                "page1" -> Page1(
                    modifier = Modifier.padding(innerPadding),
                    colors = colors,
                    context = context,
                    snackbarHostState = snackbarHostState // Passez cet état ici
                )
                "page2" -> Page2(modifier = Modifier.padding(innerPadding), colors = colors)
                "page3" -> Page3(modifier = Modifier.padding(innerPadding), colors = colors)
                "page4" -> Page4(
                    modifier = Modifier.padding(innerPadding),
                    colors = colors,
                    switchTheme = { newTheme -> themeMode = newTheme }
                )
            }
        }
    }
}


