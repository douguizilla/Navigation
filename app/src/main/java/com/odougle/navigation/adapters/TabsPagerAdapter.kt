package com.odougle.navigation.adapters

import android.content.Context
import android.content.res.TypedArray
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.odougle.navigation.R
import com.odougle.navigation.fragments.SecondLevelFragment

class TabsPagerAdapter(
    context: Context,
    fm: FragmentManager
) : FragmentPagerAdapter(fm) {

    private val tabTitles: Array<String> = context.resources.getStringArray(R.array.sections)
    private val bgColors: TypedArray = context.resources.obtainTypedArray(R.array.bg_colors)
    private val textColors: TypedArray = context.resources.obtainTypedArray(R.array.text_colors)

    override fun getCount() = 3

    override fun getItem(position: Int) = SecondLevelFragment.newInstance(
        tabTitles[position],
        bgColors.getColor(position, 0),
        textColors.getColor(position, 0)
    )

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}