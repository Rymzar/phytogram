package com.example.phytogram.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.phytogram.R


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

            if (login == "" || email == "" || phone == "" || password == "" || repeatPassword == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else if (password != repeatPassword) {
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_LONG).show()
                userPassword.text.clear()
                repeatUserPass.text.clear()
            } else {
                //допилить post and get request
            }
                val url = "http://localhost:8080/registration"
                //val stringRequest =

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}