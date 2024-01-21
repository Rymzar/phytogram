package com.example.phytogram.models

import androidx.room.Entity
import androidx.room.PrimaryKey

// объект класса пользователя дл переда данных в БД
@Entity(tableName = "user_data")
class User(
    @PrimaryKey
    val id: Int,
    val login: String,
    val email: String,
    val phone: String,
    val password: String
    //val repeatPassword: String
) {
}