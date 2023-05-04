package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_page)


        val btnsignin = findViewById<Button>(R.id.signin)
        val btnsignup = findViewById<Button>(R.id.signup)
        btnsignin.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }

        btnsignup.setOnClickListener {
            val intent = Intent(this, SelectSignUp::class.java)
            startActivity(intent)
        }
    }
}