package com.dia.firstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dia.firstandroidapp.databinding.ActivityHomeBinding
import com.dia.firstandroidapp.fragment.HomeFragment
import com.dia.firstandroidapp.fragment.ProfileFragment
import com.dia.firstandroidapp.fragment.TransactionFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    showFragments(binding.flHome.id, HomeFragment.newInstance("", ""))
                    true
                }
                R.id.navigation_transaction -> {
                    showFragments(binding.flHome.id, TransactionFragment.newInstance("", ""))
                    true
                }
                R.id.navigation_profile -> {
                    showFragments(binding.flHome.id, ProfileFragment.newInstance("", ""))
                    true
                }
                else -> {false}
            }
        }
    }

    private fun showFragments(id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.flHome.id, fragment)
            .commitAllowingStateLoss()
    }
}