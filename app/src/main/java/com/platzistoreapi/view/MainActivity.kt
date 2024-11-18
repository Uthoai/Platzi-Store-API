package com.platzistoreapi.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.platzistoreapi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*navController = findNavController(R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this,navController)*/

    }

    /*override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }*/
}