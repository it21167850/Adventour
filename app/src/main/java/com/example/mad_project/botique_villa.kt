package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class botique_villa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_botique_villa)

        val villaA=findViewById<Button>(R.id.buttonA)

        villaA.setOnClickListener {
            val intent = Intent( this,villa::class.java)
            startActivity(intent)
        }

        val villaC=findViewById<Button>(R.id.buttonC)

        villaC.setOnClickListener {
            val intent = Intent( this,villa::class.java)
            startActivity(intent)
        }
//        val villaB=findViewById<Button>(R.id.buttonBo)
//
//        villaB.setOnClickListener {
//            val intent = Intent( this,villa::class.java)
//            startActivity(intent)
//        }
//        val villaC=findViewById<Button>(R.id.buttonC)
//
//        villaC.setOnClickListener {
//            val intent = Intent( this,villa::class.java)
//            startActivity(intent)
//        }
//        val villaD=findViewById<Button>(R.id.buttonA)
//
//        villaD.setOnClickListener {
//            val intent = Intent( this,villa::class.java)
//            startActivity(intent)
//        }
    }
}