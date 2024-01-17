package com.example.phytogram.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.phytogram.R


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val buttonLogIn: Button = findViewById(R.id.button_loggIn)
        val linkToReg: TextView = findViewById(R.id.register_now)

        linkToReg.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        buttonLogIn.setOnClickListener {
            val intent= Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}