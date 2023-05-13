package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class kandy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kandy)

        val viewBo=findViewById<Button>(R.id.buttonBo)

        viewBo.setOnClickListener {
            val intent = Intent( this,botique_villa::class.java)
            startActivity(intent)
        }

        val viewStr=findViewById<Button>(R.id.starbutton)

        viewStr.setOnClickListener {
            val intent = Intent( this,botique_villa::class.java)
            startActivity(intent)
        }

        val viewBu=findViewById<Button>(R.id.buttonBu)

        viewBu.setOnClickListener {
            val intent = Intent( this,botique_villa::class.java)
            startActivity(intent)
        }
        //val viewBo=findViewById<Button>(R.id.butttonBo)

//        viewStar.setOnClickListener {
//            val intent = Intent( this,botique_villa::class.java)
//            startActivity(intent)
//        }
//        val viewBongo=findViewById<Button>(R.id.buttonBo)
//
//        viewBongo.setOnClickListener {
//            val intent = Intent( this,botique_villa::class.java)
//            startActivity(intent)
//        }
    }
}