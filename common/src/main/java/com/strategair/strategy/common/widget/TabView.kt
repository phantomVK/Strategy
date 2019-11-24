package com.strategair.strategy.common.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.annotation.FloatRange
import com.strategair.strategy.common.R
import com.strategair.strategy.common.service.dp
import com.strategair.strategy.common.utils.ArgbEvaluator.evaluate
import kotlinx.android.synthetic.main.layout_item_tab.view.*

class TabView @JvmOverloads
constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
        RelativeLayout(context, attrs, defStyleAttr) {

    private var colorNormal = 0
    private var colorSelected = 0

    init {
        View.inflate(context, R.layout.layout_item_tab, this)

        val a = context.obtainStyledAttributes(attrs, R.styleable.TabView)
        val foreground = a.getDrawable(R.styleable.TabView_imageNormal)!!
        val background = a.getDrawable(R.styleable.TabView_imageSelected)!!
        val rectSize = a.getDimensionPixelSize(R.styleable.TabView_rectSize, dp(30))
        val title = a.getString(R.styleable.TabView_title)
        colorNormal = a.getColor(R.styleable.TabView_colorNormal, Color.BLACK)
        colorSelected = a.getColor(R.styleable.TabView_colorSelected, Color.GRAY)
        a.recycle()

        subtitle.text = title
        subtitle.setTextColor(colorNormal)
        image.init(foreground, background, rectSize)
    }

    fun setLayoutAlpha(@FloatRange(from = 0.0, to = 1.0) alpha: Float) {
        val alphaInt = (255 * (1 - alpha)).toInt()
        image.alphaChanged(alphaInt)
        subtitle.setTextColor(evaluate(alpha, colorSelected, colorNormal))
    }

    fun setNumber(number: Int) {
        badge.setNumber(number)
    }
}
