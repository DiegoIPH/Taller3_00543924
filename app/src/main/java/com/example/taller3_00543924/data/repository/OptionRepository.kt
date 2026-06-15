package com.example.taller3_00543924.data.repository

import com.example.taller3_00543924.data.model.Option
import kotlinx.coroutines.flow.Flow

interface OptionRepository {
    fun getOptions(): Flow<List<Option>>
    suspend fun addOption(option: Option)
    suspend fun deleteOption(option: Option)
}