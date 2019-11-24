package com.strategair.strategy.common.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.view.children
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager.widget.ViewPager.SCROLL_STATE_IDLE

class TabGroup @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var viewPager: ViewPager

    fun setViewPager(pager: ViewPager) {
        viewPager = pager
        viewPager.addOnPageChangeListener(ViewPageListener())
        children.forEachIndexed { i, v -> v.setOnClickListener { viewPager.setCurrentItem(i, false) } }
    }

    private inner class ViewPageListener : OnPageChangeListener {

        private var scrollState = 0 // SCROLL_STATE_IDLE
        private var oldPosition = 0

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            (getChildAt(position) as TabView).setLayoutAlpha(positionOffset)
            (getChildAt(position + 1) as? TabView)?.setLayoutAlpha(1 - positionOffset)
        }

        override fun onPageSelected(position: Int) {
            if (scrollState == SCROLL_STATE_IDLE && oldPosition != position) {
                (getChildAt(oldPosition) as TabView).setLayoutAlpha(1F)
            }
            oldPosition = position
        }

        override fun onPageScrollStateChanged(state: Int) {
            scrollState = state
        }
    }
}
