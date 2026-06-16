package com.example.taller3_00543924.screens.options

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.taller3_00543924.Taller3_00543924Application
import com.example.taller3_00543924.data.model.Option
import com.example.taller3_00543924.data.repository.OptionRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OptionsViewModel(
    private val optionRepository: OptionRepository,
    private val questionId: Int // Recibe qué pregunta estamos gestionando
) : ViewModel() {

    val options: StateFlow<List<Option>> = optionRepository.getOptions(questionId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Companion.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    fun addOption(name: String, imageUrl: String) {
        viewModelScope.launch {
            optionRepository.addOption(name, imageUrl, questionId)
        }
    }

    fun deleteOption(option: Option) {
        viewModelScope.launch {
            optionRepository.deleteOption(option)
        }
    }

    companion object {
        // Factory dinámico mediante una función miembro
        fun provideFactory(questionId: Int) = viewModelFactory {
            initializer {
                val app =
                    this[ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY] as Taller3_00543924Application
                OptionsViewModel(app.appProvider.provideOptionRepository(), questionId)
            }
        }
    }
}