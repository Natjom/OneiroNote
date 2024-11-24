package com.example.oneironote.ui

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.background
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.KeyboardType
import com.example.oneironote.utils.saveAlarms
import com.example.oneironote.utils.loadAlarms
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.oneironote.utils.getCurrentTime


@SuppressLint("MutableCollectionMutableState")
@Composable
fun Page1(modifier: Modifier = Modifier, colors: ColorScheme, context: Context) {
    var alarmList by remember { mutableStateOf(loadAlarms(context).toMutableStateList()) }
    var newAlarmTime by remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    // Effect to check the alarm every minute
    LaunchedEffect(alarmList) {
        while (true) {
            delay(1000)
            val currentTime = getCurrentTime().substring(0, 5) // HH:mm format
            if (alarmList.contains(currentTime)) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Il est $currentTime ! 🎉")
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Snackbar host for messages
        SnackbarHost(hostState = snackbarHostState)

        Text(
            text = "Gérer les Réveils",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = newAlarmTime,
            onValueChange = { input ->
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
        Button(
            onClick = {
                val formattedTime = formatTime(newAlarmTime)
                if (formattedTime != null) {
                    alarmList.add(formattedTime)
                    saveAlarms(context, alarmList)
                    newAlarmTime = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = newAlarmTime.length == 4
        ) {
            Text("Ajouter l'heure")
        }
        Spacer(modifier = Modifier.height(16.dp))
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
                                alarmList.remove(time)
                                saveAlarms(context, alarmList)
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

fun formatTime(input: String): String? {
    if (input.length == 4) {
        val hours = input.substring(0, 2).toIntOrNull()
        val minutes = input.substring(2, 4).toIntOrNull()

        if (hours in 0..23 && minutes in 0..59) {
            return "%02d:%02d".format(hours, minutes)
        }
    }
    return null
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
    var themeState by remember { mutableStateOf("auto") }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            // Text content
            Text(
                text = "Page 4 : OPTION",
                fontSize = 32.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(16.dp))
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
                    contentColor = colors.onPrimary
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