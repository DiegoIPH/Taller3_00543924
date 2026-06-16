package com.example.taller3_00543924

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.taller3_00543924.ui.navigation.App
import com.example.taller3_00543924.ui.theme.Taller3_00543924Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller3_00543924Theme {
                App()
            }
        }
    }
}
