package com.odougle.navigation

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.odougle.navigation.databinding.ActivityBottomBinding
import com.odougle.navigation.databinding.ToolbarBinding
import com.odougle.navigation.fragments.SecondLevelFragment

class BottomActivity : AppCompatActivity() {

    private val binding: ActivityBottomBinding by lazy {
        ActivityBottomBinding.inflate(layoutInflater)
    }

    private val toolbarBinding: ToolbarBinding by lazy {
        ToolbarBinding.inflate(layoutInflater)
    }

    private val tabTitles: Array<String> by lazy {
        resources.getStringArray(R.array.sections)
    }

    private val bgColors: TypedArray by lazy {
        resources.obtainTypedArray(R.array.bg_colors)
    }

    private val textColors: TypedArray by lazy {
        resources.obtainTypedArray(R.array.text_colors)
    }

    private val tabIds = listOf(R.id.action_favorites, R.id.action_clock, R.id.action_people)

    private var currentTbIndex: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(toolbarBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        currentTbIndex = savedInstanceState?.getInt(TAB_SELECTED) ?: 0
        showFragment(currentTbIndex)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            val index = tabIds.indexOf(it.itemId)
            showFragment(index)
            true
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState?.putInt(TAB_SELECTED, currentTbIndex)
    }

    private fun showFragment(position: Int) {
        val oldTag = "aba_$currentTbIndex"
        val newTag = "aba_$position"
        currentTbIndex = position
        val transaction = supportFragmentManager.beginTransaction()
        val oldFragment = supportFragmentManager.findFragmentByTag(oldTag)
        if(oldFragment != null){
            transaction.hide(oldFragment)
        }
        var fragment = supportFragmentManager.findFragmentByTag(newTag)
        if(fragment == null){
            fragment = SecondLevelFragment.newInstance(
                tabTitles[position],
                bgColors.getColor(position, 0),
                textColors.getColor(position, 0))
            transaction.add(R.id.container, fragment, newTag)
        }
        binding.rootView.setBackgroundColor(bgColors.getColor(currentTbIndex, 0))
        transaction.show(fragment).commit()
    }

    companion object{
        const val TAB_SELECTED = "tabSelected"
    }


}