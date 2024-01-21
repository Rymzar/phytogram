package com.example.phytogram.models

// объект класса пользователя дл переда данных в БД

class User(
    val id: Int,
    val login: String,
    val email: String,
    val phone: String,
    val password: String
    //val repeatPassword: String
) {
}