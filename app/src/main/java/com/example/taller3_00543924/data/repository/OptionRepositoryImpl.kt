package com.example.taller3_00543924.data.repository

import com.example.taller3_00543924.data.database.dao.OptionDao
import com.example.taller3_00543924.data.database.entities.toEntity
import com.example.taller3_00543924.data.database.entities.toModel
import com.example.taller3_00543924.data.model.Option
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OptionRepositoryImpl(
    private val optionDao: OptionDao
) : OptionRepository {

    override fun getOptions(): Flow<List<Option>> {
        return optionDao.getAllOptions().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addOption(option: Option) {
        optionDao.insertOption(option.toEntity())
    }

    override suspend fun deleteOption(option: Option) {
        optionDao.deleteOption(option.toEntity())
    }
}