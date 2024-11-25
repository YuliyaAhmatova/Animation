package com.example.animation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageViewIV: ImageView
    private lateinit var startBTN: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageViewIV = findViewById(R.id.imageViewIV)
        startBTN = findViewById(R.id.startBTN)

        val appearance = AnimationUtils.loadAnimation(applicationContext, R.anim.appearance)
        imageViewIV.startAnimation(appearance)
        val moveLeftToRight = AnimationUtils.loadAnimation(applicationContext, R.anim.move_left_to_right)
        startBTN.startAnimation(moveLeftToRight)
        startBTN.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}