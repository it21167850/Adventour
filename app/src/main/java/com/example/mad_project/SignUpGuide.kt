package com.example.mad_project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mad_project.databinding.SignUpBinding
import com.example.mad_project.databinding.SignUpGuideBinding
import com.google.firebase.auth.FirebaseAuth



class SignUpGuide : AppCompatActivity() {

    private lateinit var binding: SignUpGuideBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnguidecreate.setOnClickListener{
            val email = binding.guideemail.text.toString()
            val pass = binding.guidepassword.text.toString()
            val confirmpass = binding.guideconfirmpass.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmpass.isNotEmpty()) {
                if(email.startsWith("guide")){
                    if (pass == confirmpass) {
                        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                            if (it.isSuccessful) {
                                val intent = Intent(this, SignUpGuideDtails::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(this, "Password is Not matching", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this, "Email is not allowed !!", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Empty Field are not allowed !!", Toast.LENGTH_SHORT).show()
            }

        }

}}