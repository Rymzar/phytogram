package com.example.phytogram.db

import androidx.lifecycle.LiveData
import com.example.phytogram.models.User

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}