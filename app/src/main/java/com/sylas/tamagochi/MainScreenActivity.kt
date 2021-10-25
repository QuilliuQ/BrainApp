package com.sylas.tamagochi

import android.media.MediaPlayer
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.sylas.tamagochi.databinding.ActivityMainScreenBinding

class MainScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
        val avatar: ImageView = findViewById(R.id.avatar)
        val avatarURL = sharedPreferences.getString("avatar","http://mskko2021.mad.hakta.pro/uploads/files/racoon.jpg")
        Glide.with(this).load(avatarURL).circleCrop().into(avatar)
        val exitText: TextView = findViewById(R.id.exit)
        exitText.visibility = View.GONE
        val navView: BottomNavigationView = binding.navView
        navView.setOnNavigationItemSelectedListener { menu ->
            when (menu.itemId){
                R.id.navigation_profile -> {
                    avatar.visibility = View.GONE
                    exitText.visibility = View.VISIBLE
                }
                else -> {   avatar.visibility = View.VISIBLE
                    exitText.visibility = View.GONE }
            }
            return@setOnNavigationItemSelectedListener true
        }
        navController = findNavController(R.id.nav_host_fragment_activity_main_screen)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)
    }

    fun profileClick(view: android.view.View) {
    }
}