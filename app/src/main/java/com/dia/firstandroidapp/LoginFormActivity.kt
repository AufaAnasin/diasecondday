package com.dia.firstandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dia.firstandroidapp.databinding.ActivityLoginFormBinding

class LoginFormActivity : AppCompatActivity() {

    // create binding untuk binding objectnya jadi bisa digunakan
    private lateinit var binding:ActivityLoginFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // set lister for button
        binding.btnLogin.setOnClickListener{
            Log.d("Clicked Login Button", "Clicked Login Button")
            toHomeActivity()
        }
    }
    fun toHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}