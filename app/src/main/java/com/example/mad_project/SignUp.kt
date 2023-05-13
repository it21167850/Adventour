package com.example.mad_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {

   private lateinit var dbRef : DatabaseReference
   private lateinit var fullName: EditText
   private lateinit var email: EditText
   private lateinit var phone: EditText
   private lateinit var address: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_user)

        val btncreate = findViewById<Button>(R.id.btnuserSubmit)

        dbRef = FirebaseDatabase.getInstance().getReference("customers")
        fullName = findViewById<EditText>(R.id.edtuserName)
        email = findViewById<EditText>(R.id.edtuserEmail)
        phone = findViewById<EditText>(R.id.edtuserPhone)
        address = findViewById<EditText>(R.id.edtuserAddress)

        btncreate.setOnClickListener {
            saveUserData()
        }
    }

    private fun saveUserData() {

        val name = fullName.text.toString()
        val email = email.text.toString()
        val phone = phone.text.toString()
        val address = address.text.toString()

        val userid = dbRef.push().key!!

        val user = UserModel(userid,name,email,phone,address)

        dbRef.child(userid).setValue(user)
            .addOnCompleteListener {
                Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignIn::class.java)
                startActivity(intent)
            }
            .addOnFailureListener{err->
                Toast.makeText(this, "Error ${err.message})", Toast.LENGTH_SHORT).show()
            }
    }
}