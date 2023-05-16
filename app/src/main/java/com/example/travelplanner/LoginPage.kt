package com.example.travelplanner

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.RemoteAction
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.RemoteViews
import android.widget.RemoteViews.RemoteView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import java.io.IOException

class LoginPage : AppCompatActivity() {
    lateinit var signUp: Button
    lateinit var loginIn: Button
    lateinit var forget: Button
    lateinit var id: String
    lateinit var password : String

    @SuppressLint("RemoteViewLayout")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window?.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        }

        signUp = findViewById(R.id.signbtn)
        signUp.setOnClickListener {
            intent = Intent(this,SignUpPage::class.java)
            startActivity(intent)
        }

        loginIn = findViewById(R.id.loginbtn)
        loginIn.setOnClickListener {
            id = findViewById<TextInputEditText>(R.id.username).text.toString()
            password = findViewById<TextInputEditText>(R.id.password).text.toString()

            if (id.isEmpty() || password.isEmpty()) {
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
            }
            else {
                if (isValid(id, password)) {
                    val sharedPreferences = getSharedPreferences("saved", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isLoggedIn", true)
                    editor.putString("id", id)
                    editor.putString("password", password)
                    editor.apply()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("uname",id)
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

                    tvv.text = "Invalid ID or Password"
                    toast.show()
                }
            }
        }

        forget = findViewById(R.id.forget)
        forget.setOnClickListener {
            intent = Intent(this,Forgot::class.java)
            startActivity(intent)
        }

    }

    fun isValid(id: String, mail: String): Boolean {
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
                    val storedMail = parts[1].trim()

                    if (id == storedId && mail == storedMail) {
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