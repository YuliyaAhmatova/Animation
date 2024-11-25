package com.example.animation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    private lateinit var titleTV: TextView
    private lateinit var registrationLL: LinearLayout
    private lateinit var registrationBTN: Button
    private lateinit var loginET: EditText
    private lateinit var passwordET: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        titleTV = findViewById(R.id.titleTV)
        registrationLL = findViewById(R.id.registrationLL)
        registrationBTN = findViewById(R.id.registrationBTN)
        loginET = findViewById(R.id.loginET)
        passwordET = findViewById(R.id.passwordET)

        val moveBottomToTop = AnimationUtils.loadAnimation(applicationContext, R.anim.move_bottom_to_top)
        registrationLL.startAnimation(moveBottomToTop)
        val moveTopToBottom = AnimationUtils.loadAnimation(applicationContext, R.anim.move_top_to_bottom)
        titleTV.startAnimation(moveTopToBottom)

        registrationBTN.setOnClickListener{
            if (loginET.text.isEmpty() || passwordET.text.isEmpty()){
                Toast.makeText(applicationContext, "Поле логина или пароля не заполнены", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
}