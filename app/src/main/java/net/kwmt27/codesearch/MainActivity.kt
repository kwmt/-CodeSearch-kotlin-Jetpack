package net.kwmt27.codesearch

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
        val toolbar: Toolbar = findViewById(R.id.toolbar) ?: return
        setSupportActionBar(toolbar)

        findNavController(R.id.main_nav_host_fragment).apply {
            val navView: BottomNavigationView = findViewById(R.id.nav_view)
            navView.setupWithNavController(this)
        }
    }
}
