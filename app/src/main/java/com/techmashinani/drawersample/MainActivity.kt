package com.techmashinani.drawersample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupDrawer()
    }

    private fun setupDrawer() {
        val actionToggle = ActionBarDrawerToggle(this@MainActivity, drawer, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        if(drawer != null) {
            drawer.addDrawerListener(actionToggle)
        }

        actionToggle.syncState()

        if(navigation_view != null) {
            navigation_view.setNavigationItemSelectedListener {
                Toast.makeText(this@MainActivity, it.title, Toast.LENGTH_LONG).show()
                drawer.closeDrawer(GravityCompat.START)
                return@setNavigationItemSelectedListener true
            }
        }
    }
}
