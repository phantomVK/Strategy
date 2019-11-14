package com.strategair.strategy.common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.strategair.strategy.common.R

class SpaceLayout @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
        FrameLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_clickable_space, this)
    }
}
