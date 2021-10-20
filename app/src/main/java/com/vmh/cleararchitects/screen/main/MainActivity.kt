package com.vmh.cleararchitects.screen.main

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation.findNavController
import com.vmh.cleararchitects.R
import com.vmh.cleararchitects.utils.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.motion_drawer_layout_menu.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val navController = findNavController(this, R.id.nav_host_fragment)
        textView3.setOnClickListener {
            navController.navigate(R.id.informationFragment)
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            }
        }
        textView4.setOnClickListener {
            navController.navigate(R.id.postsFragment)
            if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                drawer_layout.closeDrawer(GravityCompat.START)
            }
        }
        textView5.setOnClickListener {
            sessionManager.logout()
        }
    }
}
