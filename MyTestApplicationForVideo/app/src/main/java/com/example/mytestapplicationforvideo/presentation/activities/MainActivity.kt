package com.example.mytestapplicationforvideo.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mytestapplicationforvideo.R
import com.example.mytestapplicationforvideo.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.main_toolbar))
    }
}