package com.olehka.cleanandroid.feature.planetary.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.olehka.cleanandroid.R
import com.olehka.cleanandroid.databinding.ActivityPicturesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PicturesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPicturesBinding

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPicturesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupNavController()
    }

    private fun setupNavController() {
        val navController = findNavController(R.id.navHostFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}
