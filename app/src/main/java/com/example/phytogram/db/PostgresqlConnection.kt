package com.example.phytogram.db

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/*Подключение к БД*/
class PostgresqlConnection {
    fun connect(): Connection? {
        var connection: Connection? = null
        try {
            Class.forName("org.postgresql.Driver")
            /*Менять логин и пароль на свой*/
            val url = "jdbc:postgresql://localhost:5432/users"
            val username = "postgres"
            val password = "root"
            connection = DriverManager.getConnection(url, username, password)
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return connection
    }
}