package com.example.taller3_00543924

import android.app.Application
import com.example.taller3_00543924.data.AppProvider

class Taller3_00543924Application : Application() {
    val appProvider by lazy { AppProvider(this) }
}