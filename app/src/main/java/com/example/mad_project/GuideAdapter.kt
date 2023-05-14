package com.example.mad_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GuideAdapter(private val guideList: ArrayList<GuideModel>) : RecyclerView.Adapter<GuideAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.guide_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return guideList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = guideList[position]

        holder.fullName.text = currentItem.name

//        holder.itemView.setOnClickListener {
//            currentItem.guideid?.let { it1 -> onItemClick(it1) }
//        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fullName: TextView = itemView.findViewById(R.id.tvguidename)
        
    }
}
