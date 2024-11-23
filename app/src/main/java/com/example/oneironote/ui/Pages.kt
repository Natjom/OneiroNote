package com.example.oneironote.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.foundation.text.KeyboardOptions // Correct pour KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun Page1(modifier: Modifier = Modifier, colors: ColorScheme) {
    // Utilisation d'une liste immuable pour le suivi des alarmes
    var alarmList by remember { mutableStateOf(listOf<String>()) }

    // Champ texte pour entrer une nouvelle alarme
    var newAlarmTime by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Gérer les Réveils",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Champ pour entrer une heure
        OutlinedTextField(
            value = newAlarmTime,
            onValueChange = { input ->
                // Empêche d'entrer autre chose que des chiffres, limite à 4 caractères
                if (input.length <= 4 && input.all { it.isDigit() }) {
                    newAlarmTime = input
                }
            },
            label = { Text("Entrez une heure (HHmm)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Bouton pour ajouter une heure
        Button(
            onClick = {
                val formattedTime = formatTime(newAlarmTime)
                if (formattedTime != null) {
                    alarmList = alarmList + formattedTime // Ajoute l'heure à la liste
                    newAlarmTime = "" // Réinitialise le champ d'entrée
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = newAlarmTime.length == 4 // Active le bouton seulement quand 4 chiffres sont saisis
        ) {
            Text("Ajouter l'heure")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Liste des heures
        if (alarmList.isNotEmpty()) {
            Text(
                text = "Liste des heures de réveil",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(alarmList) { time ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = time,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                        Button(
                            onClick = {
                                alarmList = alarmList - time // Supprime l'heure de la liste
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                        ) {
                            Text("Supprimer")
                        }
                    }
                }
            }
        } else {
            Text(
                text = "Aucune heure de réveil ajoutée.",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

// Fonction pour formater une entrée de type "HHmm" en "HH:mm"
fun formatTime(input: String): String? {
    if (input.length == 4) {
        val hours = input.substring(0, 2).toIntOrNull()
        val minutes = input.substring(2, 4).toIntOrNull()

        if (hours in 0..23 && minutes in 0..59) {
            return "%02d:%02d".format(hours, minutes) // Retourne le format "HH:mm"
        }
    }
    return null // Retourne null si le format est invalide
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