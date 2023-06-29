package com.example.mad_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.example.mad_project.databinding.ActivityUpdatingArecordsBinding
import com.example.mad_project.databinding.UpdatingARecordeBinding
import com.google.firebase.database.*
import java.util.Date
import java.util.jar.Attributes.Name

class updating_a_records : AppCompatActivity() {

    private lateinit var binding: UpdatingARecordeBinding
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UpdatingARecordeBinding.inflate(layoutInflater)


        setContentView(binding.root)

        binding.btn40.setOnClickListener {
            val name = binding.cusName.text.toString()
            val phone = binding.cusPhone.text.toString()
            val email = binding.cusEmail.text.toString()
            val date = binding.cusDate.text.toString()
            val nights = binding.cusNights.text.toString()
            val people = binding.cusPeoples.text.toString()

            updateData(name,phone,email,date,nights,people )

        }
        binding.deletebtn.setOnClickListener {
            val name = binding.cusName.text.toString()

            if(name.isNotEmpty()){
                deleteData(name)
            }else{
                Toast.makeText(this,"plese enter name",Toast.LENGTH_SHORT).show()

            }

        }




        binding.btnSerch.setOnClickListener {
            val cusName: String = binding.serch.text.toString()
            if (cusName.isNotEmpty()) {
                readData(cusName)
            } else {
                Toast.makeText(this, "enter name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(cusName:String) {

        databaseReference = FirebaseDatabase.getInstance().getReference("booking")
        databaseReference.orderByChild("cusName").equalTo(cusName)

            .addListenerForSingleValueEvent(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {

                    //if user exist in firebase db
                    if (dataSnapshot.exists()) {

                        // Data exists, retrieve the value
                        for (Data in dataSnapshot.children) {

                            //fetching data from DB
                            val userData = Data.getValue(AddtocartModel::class.java)

                            if (userData!=null) {
                                //val Nic= userData.cusNic.toString()
                                val name = userData.cusName.toString()
                                val phone = userData.cusPhone.toString()
                                val email = userData.cusEmail.toString()
                                val date = userData.cusDate.toString()
                                val nights = userData.cusNight.toString()
                                val people = userData.cusPeople.toString()
                                //Toast.makeText(this, "Result Found", Toast.LENGTH_SHORT).show()
                                binding.serch.text.clear()





                                binding.cusName.setText(name.toString())
                                binding.cusPhone.setText(phone.toString())
                                binding.cusEmail.setText(email.toString())
                                binding.cusDate.setText(date.toString())
                                //binding.NewNic.setText(Nic.toString())
                                binding.cusNights.setText(nights.toString())
                                binding.cusPeoples.setText(people.toString())

                            } else {
                                //Toast.makeText(this, "ID is not exist", Toast.LENGTH_SHORT).show()
                               Log.d("TAG", "Data is empty")


                            }




                        }

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })








//            if (it.exists()) {
//                val Nic=it.child("cusNic").value
//                val name = it.child("cusName").value
//                val phone = it.child("cusPhone").value
//                val email = it.child("cusEmail").value
//                val date = it.child("cusDate").value
//                val nights = it.child("cusNight").value
//                val people = it.child("cusPeople").value
//                Toast.makeText(this, "Result Found", Toast.LENGTH_SHORT).show()
//                binding.serch.text.clear()
//
//
//
//                binding.newDate.setText(date.toString())
//                binding.newMail.setText(email.toString())
//                binding.editcusName.setText(name.toString())
//                binding.NewNic.setText(Nic.toString())
//                binding.newNights.setText(nights.toString())
//                binding.newPeoples.setText(people.toString())
//                binding.newphone.setText(phone.toString())
//            } else {
//                Toast.makeText(this, "ID is not exist", Toast.LENGTH_SHORT).show()
//
//            }
//        }.addOnFailureListener {
//            Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show()
//        }

    }
    private fun updateData(cusName:String,cusPhone:String,cusEmail:String,cusDate:String,cusNight:String, cusPeople:String){
        databaseReference = FirebaseDatabase.getInstance().getReference("booking")
        val user= mapOf<String,String>("cusName" to cusName,"cusPhone" to cusPhone,"cusEmail" to cusEmail, "cusDate" to cusDate,"cusNight" to cusNight,"cusPeople" to cusPeople)
        databaseReference.child(cusName).updateChildren(user).addOnSuccessListener {
            //binding.cusName.text.clear()
            binding.cusPhone.text.clear()
            binding.cusEmail.text.clear()
            binding.cusDate.text.clear()
            binding.cusNights.text.clear()
            binding.cusPeoples.text.clear()
            Toast.makeText(this,"updated",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"unable update",Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteData(cusName: String){
        databaseReference=FirebaseDatabase.getInstance().getReference("booking")
        databaseReference.child(cusName).removeValue().addOnSuccessListener {
            binding.cusName.text.clear()
            binding.cusPhone.text.clear()
            binding.cusEmail.text.clear()
            binding.cusDate.text.clear()
            binding.cusNights.text.clear()
            binding.cusPeoples.text.clear()

            Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{
            Toast.makeText(this,"unable update",Toast.LENGTH_SHORT).show()
        }
        }
    }







