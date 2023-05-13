package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnFind=findViewById<Button>(R.id.btnFind)

        btnFind.setOnClickListener {
            val intent = Intent( this,kandy::class.java)
            startActivity(intent)
        }

        val Destination=findViewById<Button>(R.id.btnDesti)

        Destination.setOnClickListener {
            val intent = Intent( this,select_destination::class.java)
            startActivity(intent)
        }

    }
}