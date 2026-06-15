package com.example.taller3_00543924.data.model

import com.example.taller3_00543924.data.database.entities.QuestionEntity

data class Question(
    val id: Int = 0,
    val title: String,
    val optionCount: Int = 0,
)

fun Question.toEntity(): QuestionEntity {
    return QuestionEntity(
        id = id,
        title = title,
    )
}