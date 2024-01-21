package com.example.phytogram.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.phytogram.R
import com.example.phytogram.retrofit.UserApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()
        val loginUser: TextView = findViewById(R.id.userName)
        val passwordUser: TextView = findViewById(R.id.pass)
        val buttonLogIn: Button = findViewById(R.id.button_loggIn)
        val linkToReg: TextView = findViewById(R.id.register_now)

        linkToReg.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
        //перехват логов
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        //функция Retrofit
        val retrofit = Retrofit.Builder().baseUrl("http://localhost:8080")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val userApi = retrofit.create(UserApi::class.java)

        buttonLogIn.setOnClickListener {
            val login  = loginUser.text.toString().trim()
            val pass = passwordUser.text.toString().trim()
            CoroutineScope(Dispatchers.IO).launch {
                val user = userApi.getUserById(login)
                runOnUiThread {
                    if (login == user.login && pass == user.password) {
                        Toast.makeText(this, "Пользователь найден", Toast.LENGTH_LONG).show()
                    }
                }

            }




        }

    }
}