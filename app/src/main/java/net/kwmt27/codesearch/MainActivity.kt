package net.kwmt27.codesearch

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import net.kwmt27.codesearch.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        setSupportActionBar(binding.toolbar)

        val navController = Navigation.findNavController(this, R.id.main_nav_host_fragment)
        setupActionBar(navController)
        setupNavigationMenu(navController)
    }

    override fun onSupportNavigateUp(): Boolean =
            NavigationUI.navigateUp(binding.drawerLayout, Navigation.findNavController(this, R.id.main_nav_host_fragment))

    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
    }

    private fun setupNavigationMenu(navController: NavController) {
        NavigationUI.setupWithNavController(binding.navView, navController)
    }
}
