package com.example.taller3_00543924.data

import android.content.Context
import com.example.taller3_00543924.data.database.AppDatabase
import com.example.taller3_00543924.data.repository.OptionRepository
import com.example.taller3_00543924.data.repository.OptionRepositoryImpl

class AppProvider(context: Context) {

    private val appDatabase = AppDatabase.getDatabase(context)
    private val optionDao = appDatabase.optionDao()

    private val optionRepository: OptionRepository =
        OptionRepositoryImpl(optionDao)

    fun provideOptionRepository(): OptionRepository {
        return optionRepository
    }
}