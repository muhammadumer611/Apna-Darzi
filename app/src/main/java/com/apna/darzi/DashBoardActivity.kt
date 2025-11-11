package com.apna.darzi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.apna.darzi.databinding.ActivitydashBoardBinding

class DashBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivitydashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitydashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Default Fragment (Home)
        replaceFragment(Fragment())

        // ✅ Bottom Navigation item selection
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_buy -> {
                    replaceFragment(BuyFragment())
                    true
                }
                R.id.nav_chats -> {
                    replaceFragment(FragmentChat())
                    true
                }

                R.id.nav_profile -> {
                    replaceFragment(PersonalInfoFragment())
                    true
                }
                else -> false
            }
        }
    }

    // ✅ Helper function to replace fragments
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
