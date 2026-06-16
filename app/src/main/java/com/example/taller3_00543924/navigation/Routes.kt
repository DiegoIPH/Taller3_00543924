package com.example.taller3_00543924.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object QuestionsScreen : Routes()

    @Serializable
    data class OptionsScreen(val questionId: Int) : Routes()
}