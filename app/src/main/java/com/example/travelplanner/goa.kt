package com.example.travelplanner

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.core.content.ContextCompat

class goa : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goa)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window?.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        }

        val mmt = findViewById<TextView>(R.id.mmt)
        val tc = findViewById<TextView>(R.id.tc)
        val th = findViewById<TextView>(R.id.th)
        val tm = findViewById<TextView>(R.id.tm)

        mmt.setOnClickListener {
            val url = "https://www.makemytrip.com/holidays-india/goa-travel-packages.html"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        tm.setOnClickListener {
            val url = "https://www.trivago.in/en-IN/odr/hotels-goa-india?search=200-64932"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        tc.setOnClickListener {
            val url = "https://www.yatra.com/india-tour-packages/holidays-in-goa"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        th.setOnClickListener {
            val url = "https://www.thrillophilia.com/states/goa/tours"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

    }
}