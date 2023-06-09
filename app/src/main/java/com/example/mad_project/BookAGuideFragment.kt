package com.example.mad_project

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class BookAGuideFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view =  inflater.inflate(R.layout.fragment_book_a_guide, container, false)

        val button = view.findViewById<Button>(R.id.btnselect_guide)

        // Set a click listener on the button
        button.setOnClickListener {
            // Navigate to another fragment or layout
            // For example:
            val nextFragment = GuideListFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, nextFragment)
                .addToBackStack(null)
                .commit()
        }
        return view
    }


}