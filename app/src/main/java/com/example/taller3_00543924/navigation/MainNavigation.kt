package com.example.taller3_00543924.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.taller3_00543924.ui.options.OptionsScreen
import com.example.taller3_00543924.ui.questions.QuestionsScreen

@Composable
fun App() {
    val backStack = rememberNavBackStack(Routes.QuestionsScreen)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {

            entry<Routes.QuestionsScreen> {
                QuestionsScreen(
                    onQuestionClick = { id ->
                        backStack.add(Routes.OptionsScreen(questionId = id))
                    }
                )
            }

            entry<Routes.OptionsScreen> { route ->
                OptionsScreen(
                    questionId = route.questionId,
                    onBackClick = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}