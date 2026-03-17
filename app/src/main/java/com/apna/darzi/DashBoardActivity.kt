package com.apna.darzi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.apna.darzi.databinding.ActivitydashBoardBinding

class DashBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivitydashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitydashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.selectedItemId = R.id.nav_buy
        replaceFragment(BuyFragment())

        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_buy, R.id.nav_purchase -> {
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

        binding.fabAdd.setOnClickListener {
            binding.bottomNav.selectedItemId = R.id.nav_buy
            replaceFragment(BuyFragment())
            Toast.makeText(this, getString(R.string.buy_screen_title), Toast.LENGTH_SHORT).show()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
