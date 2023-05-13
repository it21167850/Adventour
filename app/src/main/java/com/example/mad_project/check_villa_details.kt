package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class check_villa_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_villa_details)

        val button21=findViewById<Button>(R.id.button21)

        button21.setOnClickListener {
            val intent = Intent( this,addtocart::class.java)
            startActivity(intent)
        }


        }
    }
