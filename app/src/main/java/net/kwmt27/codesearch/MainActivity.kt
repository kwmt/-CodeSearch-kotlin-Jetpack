package net.kwmt27.codesearch

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import net.kwmt27.codesearch.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)
        setSupportActionBar(binding.toolbar)

        findNavController(R.id.main_nav_host_fragment).apply {
            setupActionBar(this)
            setupNavigationMenu(this)
        }
    }

    override fun onSupportNavigateUp(): Boolean =
            navigateUp(binding.drawerLayout, findNavController(R.id.main_nav_host_fragment))

    private fun setupActionBar(navController: NavController) =
            setupActionBarWithNavController(navController, binding.drawerLayout)

    private fun setupNavigationMenu(navController: NavController) = binding.navView.setupWithNavController(navController)
}
