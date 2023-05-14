package com.example.mad_project

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class GuideList : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var guideArrayList : ArrayList<GuideModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guidelist)

        userRecyclerview = findViewById(R.id.guideList)
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        guideArrayList = arrayListOf<GuideModel>()
        getUserData()
}

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("guide")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()){

                    for (userSnapshot in snapshot.children){


                        val user = userSnapshot.getValue(GuideModel::class.java)
                        guideArrayList.add(user!!)

                    }

                    userRecyclerview.adapter = GuideAdapter(guideArrayList)


                }

            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("UserlistActivity", error.message)
            }


        })
    }
}