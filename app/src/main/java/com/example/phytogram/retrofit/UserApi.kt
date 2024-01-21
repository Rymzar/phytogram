package com.example.phytogram.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("auth/{login}")
    suspend fun getUserById(@Path("login") login: String): User
}