package com.example.tipcalculator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tipcalculator.R
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.example.tipcalculator.fragment.HomeFragment
import com.example.tipcalculator.fragment.ProfileFragment

class Main : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = HomeFragment()
        val secondFragment = ProfileFragment()

        setCurrentFragment(firstFragment)
        binding.bottomNav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.profile->setCurrentFragment(secondFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(binding.flFragment.id, fragment)
            commit()
    }

}