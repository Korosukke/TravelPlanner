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

class uttarakhand : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uttarakhand)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window?.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        }

        val mmt = findViewById<TextView>(R.id.mmt)
        val tc = findViewById<TextView>(R.id.tc)
        val th = findViewById<TextView>(R.id.th)
        val tm = findViewById<TextView>(R.id.tm)

        mmt.setOnClickListener {
            val url = "https://www.makemytrip.com/holidays-india/uttarakhand-travel-packages.html"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        tm.setOnClickListener {
            val url = "http://uttarakhandtourism.gov.in/tour-packages"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        tc.setOnClickListener {
            val url = "https://www.thomascook.in/holidays/india-tour-packages/uttarakhand-tour-packages"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        th.setOnClickListener {
            val url = "https://www.thrillophilia.com/states/uttarakhand/tours"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

    }
}