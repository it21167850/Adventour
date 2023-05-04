package com.example.mad_project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mad_project.databinding.SignInBinding
import com.example.mad_project.databinding.SignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {

    private lateinit var binding:SignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnsignin.setOnClickListener {
            val email = binding.edtemail.text.toString()
            val pass = binding.edtpass.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if(it.isSuccessful){
                        val intent = Intent(this, home::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this, "Empty Field are not allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}