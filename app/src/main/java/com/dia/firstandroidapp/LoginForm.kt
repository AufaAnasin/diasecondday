package com.dia.firstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class LoginForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)
    }

    val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
    val password = passwordEditText.text.toString()
}