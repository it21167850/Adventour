package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class travel_cart1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_cart1)

        val viewAddedStays=findViewById<Button>(R.id.btnCheck)

        viewAddedStays.setOnClickListener {
            val intent = Intent( this,updating_a_records::class.java)
            startActivity(intent)
        }
    }
}