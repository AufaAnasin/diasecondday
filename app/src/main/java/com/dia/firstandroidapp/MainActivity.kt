package com.dia.firstandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dia.firstandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // untuk Binding ketika mau pindah activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set up click listener
        binding.buttonStartMain.setOnClickListener{
            Log.d("Clicked", "Clicked")
            toLoginActivity()
        }
    }
    fun toLoginActivity() {
        val intent = Intent(this, LoginFormActivity::class.java)
        startActivity(intent)
    }
}