package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class villa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_villa)

        val checkTheVilla=findViewById<Button>(R.id.btnCheck)

        checkTheVilla.setOnClickListener {
            val intent = Intent( this,check_villa_details::class.java)
            startActivity(intent)
        }

        val viewTheVilla=findViewById<Button>(R.id.btnView)

        viewTheVilla.setOnClickListener {
            val intent = Intent( this,view_villa::class.java)
            startActivity(intent)
        }
    }
}