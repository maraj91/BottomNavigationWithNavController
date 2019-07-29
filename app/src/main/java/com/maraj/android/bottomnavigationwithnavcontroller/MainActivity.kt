package com.maraj.android.bottomnavigationwithnavcontroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.ui.setupWithNavController
import android.view.LayoutInflater
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this@MainActivity, R.id.my_nav_host)
        bottom_navigation_view.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.fragmentOne -> {
                    bottom_navigation_view.visibility = View.VISIBLE
                }
                R.id.fragmentTwo -> {
                    bottom_navigation_view.visibility = View.VISIBLE
                }
                R.id.fragmentThree -> {
                    bottom_navigation_view.visibility = View.VISIBLE
                }
                else -> {
                    bottom_navigation_view.visibility = View.GONE
                }
            }
        }

        setBadge()
    }

    private fun setBadge() {
        val bottomNavigationMenuView = bottom_navigation_view.getChildAt(0) as BottomNavigationMenuView
        val v = bottomNavigationMenuView.getChildAt(2)
        val itemView = v as BottomNavigationItemView

        val badge = LayoutInflater.from(this)
            .inflate(R.layout.badge_layout, bottomNavigationMenuView, false)
        val tv = badge.findViewById<TextView>(R.id.notificationsBadgeTextView)
        tv.text = "22+"
        itemView.addView(badge)
    }
}
