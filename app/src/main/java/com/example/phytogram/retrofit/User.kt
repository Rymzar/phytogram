package com.example.phytogram.retrofit

data class User(
    val id: Long,
    val login: String,
    val email: String,
    val phone: String,
    val password: String
)
