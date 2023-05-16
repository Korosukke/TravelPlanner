package com.example.travelplanner

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.io.IOException

class SignUpPage : AppCompatActivity() {
    lateinit var fullname: TextInputEditText
    lateinit var usernm: TextInputEditText
    lateinit var pass: TextInputEditText
    lateinit var mail: TextInputEditText
    lateinit var phone: TextInputEditText
    lateinit var submit: Button
    lateinit var data1 : String
    lateinit var data2 : String
    lateinit var data3 : String
    lateinit var data4 : String
    lateinit var data5 : String
    var file = "key.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)
        fullname = findViewById(R.id.name)
        usernm = findViewById(R.id.user)
        mail = findViewById(R.id.email)
        phone = findViewById(R.id.phone)
        pass = findViewById(R.id.password)
        submit = findViewById(R.id.loginbtn)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window?.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        }

        submit.setOnClickListener {
            data1 = fullname.text.toString()
            data2 = usernm.text.toString()
            data3 = mail.text.toString()
            data4 = phone.text.toString()
            data5 = pass.text.toString()

            if(data1.isEmpty() || data2.isEmpty() || data3.isEmpty() || data4.isEmpty() || data5.isEmpty()){
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
            else if(data5.length < 8){
                val vg: ViewGroup? = findViewById(R.id.red_toast)
                val inflater = layoutInflater
                val layout: View = inflater.inflate(R.layout.custom_red_toast, vg)
                val tvv = layout.findViewById<TextView>(R.id.tview)
                val toast = Toast(applicationContext)
                toast.setGravity(Gravity.BOTTOM, 0, 50)
                toast.setView(layout)
                toast.duration = Toast.LENGTH_LONG

                tvv.text = "Minimum password length 8"
                toast.show()
            }
            else {
                try {
                    val fout = openFileOutput(file, MODE_APPEND)
                    data1 += " ";
                    data2 += " ";
                    data3 += " ";
                    data4 += "\n";
                    data5 += " ";
                    fout.write(data2.toByteArray())
                    fout.write(data5.toByteArray())
                    fout.write(data3.toByteArray())
                    fout.write(data1.toByteArray())
                    fout.write(data4.toByteArray())
                    fout.close()
//                    Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG).show()

                    val vg: ViewGroup? = findViewById(R.id.blue_toast)
                    val inflater = layoutInflater
                    val layout: View = inflater.inflate(R.layout.custom_blue_toast, vg)
                    val tvv = layout.findViewById<TextView>(R.id.tview2)
                    val toast = Toast(applicationContext)
                    toast.setGravity(Gravity.BOTTOM, 0, 50)
                    toast.setView(layout)
                    toast.duration = Toast.LENGTH_LONG
                    tvv.text = "Successfully Registered"
                    toast.show()

                    val sharedPreferences = getSharedPreferences("saved", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isLoggedIn", true)
                    editor.putString("id", data2)
                    editor.putString("password", data5)
                    editor.apply()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("uname",data2)
                    startActivity(intent)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}