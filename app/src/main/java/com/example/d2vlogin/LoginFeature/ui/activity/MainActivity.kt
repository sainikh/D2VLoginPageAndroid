package com.example.d2vlogin.LoginFeature.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.d2vlogin.LoginFeature.ui.Entity.UserAuth.isPasswordValid
import com.example.d2vlogin.LoginFeature.ui.Entity.UserAuth.isValidEmail
import com.example.d2vlogin.LoginFeature.ui.Entity.UserAuth.isValidMobile
import com.example.d2vlogin.R

import com.example.d2vlogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}