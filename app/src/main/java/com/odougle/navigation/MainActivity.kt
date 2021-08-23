package com.odougle.navigation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.odougle.navigation.databinding.ActivityMainBinding
import com.odougle.navigation.databinding.ToolbarBinding
import com.odougle.navigation.fragments.FirstLevelFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy{ ActivityMainBinding.inflate(layoutInflater)   }
    private val toolbar by lazy{ ToolbarBinding.inflate(layoutInflater) }

    private val drawerToogle : ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(this, binding.drawerLayout, toolbar.toolbar, R.string.app_name, R.string.app_name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(toolbar.toolbar)
        binding.drawerLayout.addDrawerListener(drawerToogle)
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
                binding.drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun selectMenuOption(menuItem: MenuItem) {
        menuItem.isChecked = true
        binding.drawerLayout.closeDrawers()
        val title = menuItem.title.toString()
        if(supportFragmentManager.findFragmentByTag(title) == null){
            val firstLevelFragment = FirstLevelFragment.newInstance(title)
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, firstLevelFragment, title)
                .commit()
        }
    }
}