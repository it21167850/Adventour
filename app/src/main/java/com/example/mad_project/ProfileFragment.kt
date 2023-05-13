package com.example.mad_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mad_project.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment : Fragment() {


    private lateinit var binding: FragmentProfileBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        firebaseAuth = FirebaseAuth.getInstance()
        databaseReference = FirebaseDatabase.getInstance().reference.child("customers")

        // call function to retrieve user data
        retrieveUserData()

        return binding.root
    }
    private fun retrieveUserData() {
        val currentUser = firebaseAuth.currentUser
        val userEmail = currentUser!!.email

        binding.progressBar.visibility = View.VISIBLE

        databaseReference.orderByChild("email").equalTo(userEmail).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                binding.progressBar.visibility = View.GONE
                if (snapshot.exists()) {
                    for (userSnapshot in snapshot.children) {
                        val userModel = userSnapshot.getValue(UserModel::class.java)

                        binding.nameTextView.text = userModel!!.name
                        binding.emailTextView.text = userModel.email
                        binding.phoneTextView.text = userModel.phone
                        binding.addressTextView.text = userModel.address
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(activity, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }



}