package com.example.phytogram.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.phytogram.R
import com.example.phytogram.db.DbHelper
import com.example.phytogram.models.User

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        // убирает верхнюю навигацию
        supportActionBar?.hide()
        // полуаем данные из xml файла по id
        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPhone: EditText = findViewById(R.id.user_phone)
        val userPassword: EditText = findViewById(R.id.user_password)
        val repeatUserPass: EditText = findViewById(R.id.repeat_password)
        val buttonRegistration: Button = findViewById(R.id.button_registration)
        // вешаем слушатель событий на кнопку
        buttonRegistration.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val phone = userPhone.text.toString().trim()
            val password = userPassword.text.toString().trim()
            val repeatPassword = repeatUserPass.text.toString().trim()

            // проверка пустых полей и вызов всплывающего окна
            if (login == "" || email == "" || phone == "" || password == "" || repeatPassword == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                // блок регистрации пользователя
                val user = User(login, email, phone, password)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPhone.text.clear()
                userPassword.text.clear()
                repeatUserPass.text.clear()
            }
        }
    }
}