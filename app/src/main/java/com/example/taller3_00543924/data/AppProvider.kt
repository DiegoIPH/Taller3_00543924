package com.example.taller3_00543924.data

import android.content.Context
import com.example.taller3_00543924.data.database.AppDatabase
import com.example.taller3_00543924.data.repository.OptionRepository
import com.example.taller3_00543924.data.repository.OptionRepositoryImpl
import com.example.taller3_00543924.data.repository.QuestionRepository
import com.example.taller3_00543924.data.repository.QuestionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)

    private val questionDao = appDatabase.questionDao()
    private val optionDao = appDatabase.optionDao()

    private val questionRepository: QuestionRepository =
        QuestionRepositoryImpl(questionDao)
    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideQuestionRepository(): QuestionRepository {
        return questionRepository
    }

    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }
}