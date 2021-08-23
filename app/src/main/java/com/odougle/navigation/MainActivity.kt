package com.odougle.navigation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.odougle.navigation.databinding.ActivityMainBinding
import com.odougle.navigation.databinding.ToolbarBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy{ ActivityMainBinding.inflate(layoutInflater)   }
    private val toolbar by lazy{ ToolbarBinding.inflate(layoutInflater) }
    private val drawerLayout by lazy{ binding.drawerLayout }

    private val drawerToogle : ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(this, drawerLayout, toolbar.toolbar, R.string.app_name, R.string.app_name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(toolbar.toolbar)
        drawerLayout.addDrawerListener(drawerToogle)
        drawerToogle.syncState()
        binding.navigationView.setNavigationItemSelectedListener { menuItem ->
            selectMenuOption(menuItem)
            true
        }
        if(savedInstanceState == null){
            selectMenuOption(binding.navigationView.menu.findItem(R.id.action_tab))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun selectMenuOption(menuItem: MenuItem) {
        menuItem.isChecked = true
        drawerLayout.closeDrawers()
    }
}