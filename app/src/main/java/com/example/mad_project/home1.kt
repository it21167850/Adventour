package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class home1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home1)

        val viewBo=findViewById<Button>(R.id.btnfind)

        viewBo.setOnClickListener {
            val intent = Intent( this,kandy::class.java)
            startActivity(intent)
        }

        val viewBest=findViewById<Button>(R.id.btnBest)

        viewBest.setOnClickListener {
            val intent = Intent( this,select_destination::class.java)
            startActivity(intent)
        }

    }
}