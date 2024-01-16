package com.example.phytogram.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.phytogram.R
import com.example.phytogram.db.DbHelper
import com.example.phytogram.ui.HomeActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val userLogin: EditText = findViewById(R.id.userName)
        val userPass: EditText = findViewById(R.id.pass)
        val buttonLogIn: Button = findViewById(R.id.button_loggIn)

        val linkToReg: TextView = findViewById(R.id.register_now)
        linkToReg.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        buttonLogIn.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if (isAuth) {
                    val intentHome = Intent(this, HomeActivity::class.java)
                    startActivity(intentHome)
                    userLogin.text.clear()
                    userPass.text.clear()
                } else {
                    Toast.makeText(this, "Пользователь $login не найден", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}