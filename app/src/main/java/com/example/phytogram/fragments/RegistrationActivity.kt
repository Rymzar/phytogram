package com.example.phytogram.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import com.example.phytogram.R


class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        // убирает верхнюю навигацию
        supportActionBar?.hide()
        // полуаем данные из xml файла по id
        val buttonRegistration: Button = findViewById(R.id.button_registration)
        // вешаем слушатель событий на кнопку
        buttonRegistration.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
