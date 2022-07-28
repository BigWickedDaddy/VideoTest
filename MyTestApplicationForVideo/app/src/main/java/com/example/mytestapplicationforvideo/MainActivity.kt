package com.example.mytestapplicationforvideo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.replace
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mytestapplicationforvideo.databinding.ActivityMainBinding
import com.example.mytestapplicationforvideo.presentation.IconFragment
import com.example.mytestapplicationforvideo.presentation.appComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        this.applicationContext.appComponent.inject(VideoApp())

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        findNavigation()
        setSupportActionBar(findViewById(R.id.main_toolbar))
    }

    private fun findNavigation() {
        controller = findController(R.id.container)

        with(binding) {
            btnIcon.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .replace<IconFragment>(R.id.container)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onBackPressed() {
        when (supportFragmentManager.backStackEntryCount) {
            0 -> super.onBackPressed()
            else -> supportFragmentManager.popBackStack()
        }
    }

    private fun AppCompatActivity.findController(id: Int): NavController {
        return (supportFragmentManager.findFragmentById(id) as NavHostFragment).navController
    }
}