package com.example.mad_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AdminDashboard : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.admin_dashboard)

        val manageuserbtn = findViewById<Button>(R.id.btnmanage_user)

        manageuserbtn.setOnClickListener {
            val intent = Intent(this,UserlistActivity::class.java)
            startActivity(intent)
        }


}}