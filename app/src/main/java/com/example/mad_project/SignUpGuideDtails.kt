package com.example.mad_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpGuideDtails : AppCompatActivity() {

    private lateinit var dbRef : DatabaseReference
    private lateinit var fullName: EditText
    private lateinit var email: EditText
    private lateinit var nic: EditText
    private lateinit var phone: EditText
    private lateinit var description: EditText
    private lateinit var english: CheckBox
    private lateinit var french: CheckBox
    private lateinit var chinese: CheckBox
    private lateinit var german: CheckBox
    private lateinit var korean: CheckBox
    private lateinit var spanish: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guide_details)

        var btncreate = findViewById<Button>(R.id.btnguideSubmit)

        dbRef = FirebaseDatabase.getInstance().getReference("guide")
        fullName = findViewById<EditText>(R.id.edtguideName)
        email = findViewById<EditText>(R.id.edtguideEmail)
        nic = findViewById<EditText>(R.id.edtguideNic)
        phone = findViewById<EditText>(R.id.edtguidePhone)
        description = findViewById<EditText>(R.id.edtguideDes)
        english = findViewById<CheckBox>(R.id.checkBoxenglish)
        french = findViewById<CheckBox>(R.id.checkBoxfrench)
        chinese = findViewById<CheckBox>(R.id.checkBoxchines)
        german = findViewById<CheckBox>(R.id.checkBoxgerman)
        korean = findViewById<CheckBox>(R.id.checkBoxkorean)
        spanish = findViewById<CheckBox>(R.id.checkBoxSpanish)


        btncreate.setOnClickListener {
            saveGuideData()
        }

}

    private fun saveGuideData() {
        val name = fullName.text.toString()
        val email = email.text.toString()
        val nic = nic.text.toString()
        val phone = phone.text.toString()
        val description = description.text.toString()

        val languages = ArrayList<String>()
        if (english.isChecked) {
            languages.add("English")
        }
        if (french.isChecked) {
            languages.add("French")
        }
        if (chinese.isChecked) {
            languages.add("Chinese")
        }
        if (german.isChecked) {
            languages.add("German")
        }
        if (korean.isChecked) {
            languages.add("Korean")
        }
        if (spanish.isChecked) {
            languages.add("Spanish")
        }

        val guideid = dbRef.push().key!!
        val guide = GuideModel(guideid, name, email, nic, phone, description, languages)

        dbRef.child(guideid).setValue(guide)
            .addOnCompleteListener {
                Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignIn::class.java)
                startActivity(intent)
            }
            .addOnFailureListener { err ->
                Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
            }
    }

}