package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class view_villa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_villa)

        val checkTheVilla=findViewById<Button>(R.id.button15)

        checkTheVilla.setOnClickListener {
            val intent = Intent( this,check_villa_details::class.java)
            startActivity(intent)
        }
    }
}