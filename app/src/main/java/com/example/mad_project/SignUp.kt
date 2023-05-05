package com.example.mad_project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

//   private lateinit var dbRef : DatabaseReference
//   private lateinit var fullName: EditText
//   private lateinit var email: EditText
//   private lateinit var phone: EditText
//   private lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_user)

//        val btncreate = findViewById<Button>(R.id.btncreateguide)
//
//        dbRef = FirebaseDatabase.getInstance().getReference("customers")
//        fullName = findViewById<EditText>(R.id.fullName)
//        email = findViewById<EditText>(R.id.email)
//        phone = findViewById<EditText>(R.id.phone)
//        password = findViewById<EditText>(R.id.password)
//
//        btncreate.setOnClickListener {
//            saveUserData()
//        }
    }

//    private fun saveUserData() {
//
//        val name = fullName.text.toString()
//        val email = email.text.toString()
//        val phone = phone.text.toString()
//        val password = password.text.toString()
//
//        val userid = dbRef.push().key!!
//
//        val user = UserModel(userid,name,email,phone,password)
//
//        dbRef.child(userid).setValue(user)
//            .addOnCompleteListener {
//                Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
//            }
//            .addOnFailureListener{err->
//                Toast.makeText(this, "Error ${err.message})", Toast.LENGTH_SHORT).show()
//            }
//    }
}