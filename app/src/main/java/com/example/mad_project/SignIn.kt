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

        binding.noaccount.setOnClickListener {
            val intent = Intent(this , SelectSignUp::class.java)
            startActivity(intent)
        }
        binding.btnsignin.setOnClickListener {
            val email = binding.edtemail.text.toString()
            val pass = binding.edtpass.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                    if(it.isSuccessful){
                        // Check if the user is admin
                        if (email.startsWith("admin")) {
                            val intent = Intent(this, AdminDashboard::class.java)
                            startActivity(intent)
                        }
                        // Check if the user is guide
                        else if (email.startsWith("guide")) {
                            val intent = Intent(this, GuideDashboard::class.java)
                            startActivity(intent)
                        }
                        // Otherwise, the user is a customer
                        else {
                            val intent = Intent(this, home::class.java)
                            startActivity(intent)
                        }
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
