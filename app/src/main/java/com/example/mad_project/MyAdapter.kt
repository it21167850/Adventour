package com.example.mad_project

import android.provider.SyncStateContract.Helpers.update
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.nio.file.Files.delete


class MyAdapter(private val userList : ArrayList<UserModel>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.fullName.text = currentitem.name
        holder.email.text = currentitem.email
        holder.phone.text = currentitem.phone
        holder.address.text = currentitem.address



    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val fullName : TextView = itemView.findViewById(R.id.tvfullName)
        val email : TextView = itemView.findViewById(R.id.tvemail)
        val phone : TextView = itemView.findViewById(R.id.tvphone)
        val address : TextView = itemView.findViewById(R.id.tvaddress)

        val btnUpdate : Button = itemView.findViewById(R.id.userUpdate)
        val btnDelete : Button = itemView.findViewById(R.id.userDelete)
    }

}