package com.example.travelplanner

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        val uk = view.findViewById<ConstraintLayout>(R.id.uttarakhand)
        uk.setOnClickListener{
            val intent = Intent(requireActivity(), uttarakhand::class.java)
            startActivity(intent)
        }

        val ga = view.findViewById<ConstraintLayout>(R.id.goa)
        ga.setOnClickListener{
            val intent = Intent(requireActivity(), goa::class.java)
            startActivity(intent)
        }

        val kr = view.findViewById<ConstraintLayout>(R.id.kerala)
        kr.setOnClickListener{
            val intent = Intent(requireActivity(), kerala::class.java)
            startActivity(intent)
        }

        val ss = view.findViewById<ConstraintLayout>(R.id.seven)
        ss.setOnClickListener{
            val intent = Intent(requireActivity(), seven_sis::class.java)
            startActivity(intent)
        }

        val rj = view.findViewById<ConstraintLayout>(R.id.rajasthan)
        rj.setOnClickListener{
            val intent = Intent(requireActivity(), rajasthan::class.java)
            startActivity(intent)
        }
        return view
    }

}
