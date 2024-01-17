package com.example.phytogram.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.phytogram.models.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_data ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Query("DELETE FROM user_data")
    fun deletAllUsers()
}