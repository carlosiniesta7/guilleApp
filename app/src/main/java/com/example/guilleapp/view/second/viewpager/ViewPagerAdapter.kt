package com.example.guilleapp.view.second.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter internal constructor(private val lFragment: List<Fragment>, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? = lFragment[position]

    override fun getCount(): Int = lFragment.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Thanks "
            1 -> "Created by"
            else -> { // Note the block
                "Unknown"
            }
        }
    }
}