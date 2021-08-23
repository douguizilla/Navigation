package com.odougle.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.navigation.adapters.TabsPagerAdapter
import com.odougle.navigation.databinding.ActivityPagerBinding
import com.odougle.navigation.databinding.ToolbarBinding

class PagerActivity : AppCompatActivity() {
    private val binding: ActivityPagerBinding by lazy {
        ActivityPagerBinding.inflate(layoutInflater)
    }
    private val toolbarBinding: ToolbarBinding by lazy {
        ToolbarBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(toolbarBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val tabsPagerAdapter = TabsPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = tabsPagerAdapter

    }
}