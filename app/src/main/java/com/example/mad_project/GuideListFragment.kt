package com.example.mad_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class GuideListFragment : Fragment(R.layout.fragment_guide_list) {

    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerview: RecyclerView
    private lateinit var guideArrayList: ArrayList<GuideModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userRecyclerview = view.findViewById(R.id.guideList)
        userRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        userRecyclerview.setHasFixedSize(true)

        guideArrayList = arrayListOf<GuideModel>()
        getUserData()
    }

    private fun getUserData() {
        dbref = FirebaseDatabase.getInstance().getReference("guide")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(GuideModel::class.java)
                        guideArrayList.add(user!!)
                    }

                    userRecyclerview.adapter = GuideAdapter(guideArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("GuideListFragment", error.message)
            }
        })
    }
//    private fun selectGuide(guideid: String) {
//        val action = GuideListFragmentDirections.actionGuideListFragmentToEnglishGuideFragment(guideid)
//        findNavController().navigate(action)
//    }
}
