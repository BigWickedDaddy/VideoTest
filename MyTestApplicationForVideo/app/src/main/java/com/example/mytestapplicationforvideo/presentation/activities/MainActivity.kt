package com.example.mytestapplicationforvideo.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.mytestapplicationforvideo.R
import com.example.mytestapplicationforvideo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        with(binding){
            btnIcon.setOnClickListener{
                val intent= Intent(this@MainActivity , VideoActivity::class.java)
                startActivity(intent)
            }
        }
        setSupportActionBar(findViewById(R.id.main_toolbar))
    }
}