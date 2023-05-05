package com.example.mad_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SelectSignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select)

        val btncustomer = findViewById<Button>(R.id.btncus)
        val btnguide = findViewById<Button>(R.id.btnguide)

        btncustomer.setOnClickListener {
            val intent = Intent(this, SignUpAuth::class.java)
            startActivity(intent)
        }
        btnguide.setOnClickListener {
            val intent = Intent(this, SignUpGuide::class.java)
            startActivity(intent)
        }
}}