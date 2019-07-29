package com.maraj.android.bottomnavigationwithnavcontroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*
import androidx.navigation.NavDestination
import androidx.navigation.ui.setupWithNavController


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
    }
}
