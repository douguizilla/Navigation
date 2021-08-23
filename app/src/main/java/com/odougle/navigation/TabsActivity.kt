package com.odougle.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.navigation.adapters.TabsPagerAdapter
import com.odougle.navigation.databinding.ActivityTabsBinding
import com.odougle.navigation.databinding.ToolbarBinding

class TabsActivity : AppCompatActivity() {
    private val binding: ActivityTabsBinding by lazy {
        ActivityTabsBinding.inflate(layoutInflater)
    }
    private val toolbar by lazy{ ToolbarBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(toolbar.toolbar)
        val pagerAdapter = TabsPagerAdapter(this, supportFragmentManager)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.viewPager.adapter = pagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}