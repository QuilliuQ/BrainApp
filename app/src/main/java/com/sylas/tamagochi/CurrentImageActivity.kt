package com.sylas.tamagochi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class CurrentImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_image)
        val image : ImageView = findViewById(R.id.image)
        intent.extras?.getInt("imageId").let { id->
            image.setImageResource(id!!)
        }
    }
}