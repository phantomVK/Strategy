package com.strategair.strategy.view.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.*

class HomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments = ArrayList<Fragment>(4)

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyDataSetChanged()
    }

    fun addFragments(fragment: List<Fragment>) {
        fragments.addAll(fragment)
        notifyDataSetChanged()
    }

    fun clearFragment() {
        fragments.clear()
        notifyDataSetChanged()
    }

    override fun getItem(position: Int) = fragments[position]
    override fun getCount() = fragments.size
}
