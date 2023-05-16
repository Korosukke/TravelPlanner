package com.example.travelplanner

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CheckFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_check, container, false)

        var linked = view.findViewById<TextView>(R.id.linked)
        linked.setOnClickListener {
            openUrl(view)
        }

        var send = view.findViewById<Button>(R.id.sendbtn)
        send.setOnClickListener {
            var txt = view.findViewById<TextInputEditText>(R.id.editText12)
            txt.setText("")
            val vg = view.findViewById<ViewGroup>(R.id.blue_toast)
            val inflater = layoutInflater
            val layout: View = inflater.inflate(R.layout.custom_blue_toast, vg)
            val tvv = layout.findViewById<TextView>(R.id.tview2)
            val toast = Toast(view.getContext())
            toast.setGravity(Gravity.BOTTOM, 0, 50)
            toast.setView(layout)
            toast.duration = Toast.LENGTH_LONG
            tvv.text = "Message Sent"
            toast.show()
        }

        return view
    }

    fun openUrl(view: View) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.linkedin.com/in/manasyadav95/")
        startActivity(intent)
    }

}