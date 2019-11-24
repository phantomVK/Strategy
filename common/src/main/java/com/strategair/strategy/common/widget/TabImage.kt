package com.strategair.strategy.common.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.annotation.IntRange

/**
 * TabImage for each tab in the SlideTabImage.
 */
class TabImage @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        View(context, attrs, defStyleAttr) {

    private lateinit var normalIcon: Drawable
    private lateinit var selectedIcon: Drawable
    private var alphaInt = 0

    fun init(normal: Drawable, selected: Drawable, size: Int) {
        normalIcon = normal.mutate()
        normalIcon.setBounds(0, 0, size, size)
        selectedIcon = selected.mutate()
        selectedIcon.setBounds(0, 0, size, size)
    }

    override fun onDraw(canvas: Canvas) {
        normalIcon.alpha = 255 - alphaInt
        normalIcon.draw(canvas)
        selectedIcon.alpha = alphaInt
        selectedIcon.draw(canvas)
    }

    fun alphaChanged(@IntRange(from = 0, to = 255) alpha: Int) {
        alphaInt = alpha
        invalidate()
    }
}
