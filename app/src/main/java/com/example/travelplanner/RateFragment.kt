package com.example.travelplanner

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class RateFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_rate, container, false)

        val btn = view.findViewById<Button>(R.id.ratebtn)
        btn.setOnClickListener {

            val vg = view.findViewById<ViewGroup>(R.id.blue_toast)
            val inflater = layoutInflater
            val layout: View = inflater.inflate(R.layout.custom_blue_toast, vg)
            val tvv = layout.findViewById<TextView>(R.id.tview2)
            val toast = Toast(view.getContext())
            toast.setGravity(Gravity.BOTTOM, 0, 50)
            toast.setView(layout)
            toast.duration = Toast.LENGTH_LONG
            tvv.text = "Thank you for your feedback"
            toast.show()

            val fragment = HomeFragment()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.contentContainer, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return view;
    }
}
