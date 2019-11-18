package com.strategair.strategy.common.widget

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager.widget.ViewPager

class DragViewPager : ViewPager {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    companion object {
        private const val STATUS_IDLE = 0
        private const val STATUS_MOVING = 1
        private const val STATUS_RESUMING = 2
    }
}
