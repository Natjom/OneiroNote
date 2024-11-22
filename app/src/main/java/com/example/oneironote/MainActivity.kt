package com.example.oneironote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.oneironote.ui.HomePage
import com.example.oneironote.ui.BottomNavigationBar
import com.example.oneironote.ui.Pages.*
import com.example.oneironote.ui.theme.DarkColorScheme
import com.example.oneironote.ui.theme.LightColorScheme
import com.example.oneironote.ui.theme.OneironoteTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.padding



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OneironoteTheme {
                val currentPage = remember { mutableStateOf("home") }


                val darkTheme = isSystemInDarkTheme()
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
