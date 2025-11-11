package com.apna.darzi

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.apna.darzi.databinding.ActivityLoginScreenBinding
import com.apna.darzi.databinding.ActivitySignUpScreenBinding

class ActivitySignUpScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignUp.setOnClickListener {
            intent = Intent(this@ActivitySignUpScreen, ActivityLoginScreen::class.java)
            startActivity(intent)
        }

    }
}