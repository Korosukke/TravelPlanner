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

class seven_sis : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven_sis)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window?.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        }

        val mmt = findViewById<TextView>(R.id.mmt)
        val tc = findViewById<TextView>(R.id.tc)
        val th = findViewById<TextView>(R.id.th)
        val tm = findViewById<TextView>(R.id.tm)

        mmt.setOnClickListener {
            val url = "https://www.veenaworld.com/package/north-east-seven-sisters-tour-package-nees"
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
            val url = "https://www.sotc.in/theme-holidays/seven-sisters-packages"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        th.setOnClickListener {
            val url = "https://www.thrillophilia.com/tours/the-north-east-7-sisters-tour"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

    }
}