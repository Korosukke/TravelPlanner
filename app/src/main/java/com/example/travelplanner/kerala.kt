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

class kerala : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kerala)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window?.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        }

        val mmt = findViewById<TextView>(R.id.mmt)
        val tc = findViewById<TextView>(R.id.tc)
        val th = findViewById<TextView>(R.id.th)
        val tm = findViewById<TextView>(R.id.tm)

        mmt.setOnClickListener {
            val url = "https://www.makemytrip.com/holidays-india/kerala-travel-packages.html"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        tm.setOnClickListener {
            val url = "https://www.thomascook.in/holidays/seven-sister-tour-packages"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        tc.setOnClickListener {
            val url = "https://www.yatra.com/india-tour-packages/holidays-in-kerala"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        th.setOnClickListener {
            val url = "https://www.thrillophilia.com/kerala-tour"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

    }
}