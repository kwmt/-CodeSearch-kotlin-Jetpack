package net.kwmt27.codesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
        val toolbar: Toolbar = findViewById(R.id.toolbar) ?: return
        setSupportActionBar(toolbar)

        findNavController(R.id.main_nav_host_fragment).apply {
            val navView: BottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)
            setupWithNavController(navView,this)
        }
    }
}
