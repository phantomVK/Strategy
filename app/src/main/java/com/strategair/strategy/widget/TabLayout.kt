package com.strategair.strategy.widget

import android.content.Context
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.Paint.DITHER_FLAG
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.strategair.strategy.R

class TabLayout @JvmOverloads constructor(context: Context, val attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : RelativeLayout(context, attrs, defStyleAttr) {

    private val paint = Paint(ANTI_ALIAS_FLAG or DITHER_FLAG)
    private var normalIcon: Drawable? = null
    private var selectedIcon: Drawable? = null
    private lateinit var title: String

    fun init() {
        View.inflate(context, R.layout.layout_item_tab, this)

        val a = context.obtainStyledAttributes(attrs, R.styleable.TabLayout)
        normalIcon = a.getDrawable(R.styleable.TabLayout_normalImage)
        selectedIcon = a.getDrawable(R.styleable.TabLayout_selectedImage)
        title = a.getString(R.styleable.TabLayout_title) ?: "Title"
        a.recycle()
    }

}
