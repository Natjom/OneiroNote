package com.example.oneironote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OneironoteTheme {
                val currentPage = remember { mutableStateOf("home") }

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(currentPage = currentPage)
                    }
                ) { innerPadding ->
                    // Affiche la page en fonction de l'état avec innerPadding
                    when (currentPage.value) {
                        "home" -> HomePage(modifier = Modifier.padding(innerPadding))
                        "page1" -> Page1(modifier = Modifier.padding(innerPadding))
                        "page2" -> Page2(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    val currentTime = getCurrentTime()
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = currentTime,
            fontSize = 64.sp,
            color = MaterialTheme.colorScheme.onBackground // Adapté au thème
        )
    }
}

@Composable
fun Page1(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page 1", fontSize = 32.sp)
    }
}

@Composable
fun Page2(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page 2", fontSize = 32.sp)
    }
}

@Composable
fun BottomNavigationBar(currentPage: MutableState<String>) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween, // Pour espacer les éléments
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left button (square)
            NavigationButton(
                label = "L1", // Exemple d'étiquette
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)),
                onClick = { currentPage.value = "page1" }
            )

            // Left second button (square)
            NavigationButton(
                label = "L2", // Exemple d'étiquette
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)),
                onClick = { currentPage.value = "page2" }
            )

            // Center button (round) -> Redirection vers la page "home"
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.Blue, shape = RoundedCornerShape(32.dp))
                    .clickable { currentPage.value = "home" }, // Ajoute un onClick
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Home", color = Color.White, fontSize = 12.sp)
            }

            // Right second button (square)
            NavigationButton(
                label = "R2", // Exemple d'étiquette
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)),
                onClick = { currentPage.value = "page2" }
            )

            // Right button (square)
            NavigationButton(
                label = "R1", // Exemple d'étiquette
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp)),
                onClick = { currentPage.value = "page1" }
            )
        }
    }
}



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

fun getCurrentTime(): String {
    val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return sdf.format(Date())
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OneironoteTheme {
        HomePage(modifier = Modifier.padding(16.dp))
    }
}
