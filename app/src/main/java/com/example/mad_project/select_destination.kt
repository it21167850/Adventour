package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class select_destination : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_destination)

        val kandybtn=findViewById<Button>(R.id.button20)

        kandybtn.setOnClickListener {
            val intent = Intent( this,kandy::class.java)
            startActivity(intent)
        }

        val galle=findViewById<Button>(R.id.buttonG)

        galle.setOnClickListener {
            val intent = Intent( this,kandy::class.java)
            startActivity(intent)
         }
    }
}