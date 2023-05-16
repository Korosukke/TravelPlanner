package com.example.travelplanner

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window?.statusBarColor = ContextCompat.getColor(this, R.color.blue)
        }


        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolbar)

        val headerLayout = navigationView.getHeaderView(0)
        val navtxt = headerLayout.findViewById<TextView>(R.id.nav_text)
        val bundle: Bundle? = intent.extras
        val id = bundle?.get("uname")
        navtxt.text = "Hi "+id


        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("MITTR");
        navigationView.setNavigationItemSelectedListener(this)
        var actionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,
            R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.contentContainer, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.Home)
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.Home -> supportFragmentManager.beginTransaction().replace(R.id.contentContainer,HomeFragment())
                .commit()
            R.id.nav_chat -> supportFragmentManager.beginTransaction().replace(R.id.contentContainer,RateFragment())
                .commit()
            R.id.contact -> supportFragmentManager.beginTransaction().replace(R.id.contentContainer,CheckFragment())
                .commit()
            R.id.logout -> {
                val sharedPref = getSharedPreferences("saved", Context.MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.clear()
                editor.apply()

                startActivity(Intent(this, LoginPage::class.java))
                finish()
                true
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}