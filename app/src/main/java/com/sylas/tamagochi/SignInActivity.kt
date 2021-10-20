package com.sylas.tamagochi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    fun auth(view: android.view.View) {
        val intent = Intent(this,MainScreenActivity::class.java)
        startActivity(intent)

    }


    fun register(view: android.view.View) {

    }
}