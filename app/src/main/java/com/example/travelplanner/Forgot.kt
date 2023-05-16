package com.example.travelplanner

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.io.IOException

class Forgot : AppCompatActivity() {
    lateinit var fuser: String
    lateinit var fmail : String
    lateinit var btn : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)


        btn = findViewById(R.id.otpbtn)

        btn.setOnClickListener {
            fuser = findViewById<TextInputEditText>(R.id.fuser).text.toString()
            fmail = findViewById<TextInputEditText>(R.id.fmail).text.toString()

            if (fuser.isEmpty() || fmail.isEmpty()) {
                val vg: ViewGroup? = findViewById(R.id.yellow_toast)
                val inflater = layoutInflater
                val layout: View = inflater.inflate(R.layout.custom_yellow_toast, vg)
                val tvv = layout.findViewById<TextView>(R.id.tview1)
                val toast = Toast(applicationContext)
                toast.setGravity(Gravity.BOTTOM, 0, 50)
                toast.setView(layout)
                toast.duration = Toast.LENGTH_LONG
                tvv.text = "Please fill all the fields"
                toast.show()
            } else {
                if (isValid(fuser, fmail)) {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("uname", fuser)
                    startActivity(intent)
                } else {
                    val vg: ViewGroup? = findViewById(R.id.red_toast)
                    val inflater = layoutInflater
                    val layout: View = inflater.inflate(R.layout.custom_red_toast, vg)
                    val tvv = layout.findViewById<TextView>(R.id.tview)
                    val toast = Toast(applicationContext)
                    toast.setGravity(Gravity.BOTTOM, 0, 50)
                    toast.setView(layout)
                    toast.duration = Toast.LENGTH_LONG
                    tvv.text = "Invalid Username or Mail"
                    toast.show()
                }
            }
        }

    }

    fun isValid(id: String, password: String): Boolean {
        try {
            val fin = openFileInput("key.txt")
            val bytes = ByteArray(fin.available())
            fin.read(bytes)
            fin.close()

            val content = String(bytes)
            val lines = content.split("\n")

            for (line in lines) {
                val parts = line.split(" ")
                if (parts.size >= 2) {
                    val storedId = parts[0]
                    val storedMail = parts[2].trim()

                    if (id == storedId && password == storedMail) {
                        return true
                    }
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return false
    }
}