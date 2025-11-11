package com.apna.darzi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.apna.darzi.databinding.ActivityLoginScreenBinding
import com.apna.darzi.databinding.ActivitydashBoardBinding

class ActivityLoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            intent = Intent(this@ActivityLoginScreen, DashBoardActivity::class.java)
            startActivity(intent)

        }
    }
}