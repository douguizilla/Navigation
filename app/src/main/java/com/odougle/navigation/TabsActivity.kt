package com.odougle.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.navigation.databinding.ActivityTabsBinding

class TabsActivity : AppCompatActivity() {
    private val binding: ActivityTabsBinding by lazy {
        ActivityTabsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}