package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class addtocart : AppCompatActivity() {

    private lateinit var dbRef: DatabaseReference

    lateinit var display : TextView
    lateinit var add:Button

    private lateinit var editcusName:EditText
    private lateinit var editcusPhone:EditText
    private lateinit var editcusEmail:EditText
    private lateinit var editcusDate:EditText
    private lateinit var editcusNight:EditText
    private lateinit var editcusPeople:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.activity_addtocart)

        dbRef = FirebaseDatabase.getInstance().getReference("booking")












        display=findViewById<EditText>(R.id.display_result)
        add=findViewById<Button>(R.id.btnAdd)
        editcusName=findViewById<EditText>(R.id.editcusName)
        editcusPhone=findViewById<EditText>(R.id.editcusPhone)
        editcusEmail=findViewById<EditText>(R.id.editcusEmail)
        editcusDate=findViewById<EditText>(R.id.editcusDate)
        editcusNight=findViewById<EditText>(R.id.editcusNight)
        editcusPeople=findViewById<EditText>(R.id.editcusPeople)



        add.setOnClickListener{

            val NumOfNight=editcusNight.text.toString().toInt()
            val NumOfPeople=editcusPeople.text.toString().toInt()
            addition(NumOfNight, NumOfPeople)
        }

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)



        btnSubmit.setOnClickListener {
            val intent = Intent( this,travel_cart1::class.java)
            startActivity(intent)
        }
        btnSubmit.setOnClickListener {
            saveCusData()
        }
                }


    private fun addition(NumOfNight: Int, NumOfPeople: Int) {
        val result = 1000*NumOfNight + 500*NumOfPeople
        display.text=result.toString()

    }


    private fun saveCusData() {


        val Name=editcusName.text.toString()
        val PhoneNumber=editcusPhone.text.toString()
        val Email=editcusEmail.text.toString()
        val Date=editcusDate.text.toString()
        val NumOfNight=editcusNight.text.toString()
        val NumOfPeople=editcusPeople.text.toString()



        if(Name.isEmpty()){
            editcusName.error="please enter Name"
            return
        }
        if(PhoneNumber.isEmpty()){
            editcusPhone.error="please enter phone Number"
            return
        }
        if(PhoneNumber.length<10 || PhoneNumber.length>13){
            editcusPhone.error="Invalid number"
            return
        }
        if(Email.isEmpty()){
            editcusEmail.error="please enter Email"
            return
        }
        if(Date.isEmpty()){
            editcusDate.error="please enter Date"
            return
        }
        if(NumOfNight.isEmpty()){
            editcusNight.error="please enter Number of Nights"
            return
        }
        if(NumOfPeople.isEmpty()){
            editcusPeople.error="please enter Number pf peoples"
            return
        }
        val cusName=dbRef.push().key!!

        val user =AddtocartModel(Name, PhoneNumber,Email,Date,NumOfNight,NumOfPeople)





        dbRef.child(cusName).setValue(user)
            .addOnCanceledListener {
                Toast.makeText(this,"sucsesfull booking", Toast.LENGTH_SHORT).show()
                editcusName.setText("")
                editcusPhone.setText("")
                editcusEmail.setText("")
                editcusDate.setText("")
                editcusNight.setText("")
                editcusPeople.setText("")
            }
            .addOnFailureListener { err->
                Toast.makeText(this, "Error booking ${err.message})", Toast.LENGTH_SHORT).show()
            }

        val submit=findViewById<Button>(R.id.btnSubmit)

        submit.setOnClickListener {
            val intent = Intent( this,travel_cart1::class.java)
            startActivity(intent)
        }
    }
}
