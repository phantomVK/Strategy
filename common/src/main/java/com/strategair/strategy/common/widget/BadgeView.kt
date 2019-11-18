package com.strategair.strategy.common.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.strategair.strategy.common.R
import com.strategair.strategy.common.service.sp
import kotlin.math.ceil

class BadgeView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
        AppCompatTextView(context, attrs, defStyle) {

    private var weakDiameter = 0
    private val oval = ContextCompat.getDrawable(context, R.drawable.shape_badge_view_oval)!!
    private val rectangle = ContextCompat.getDrawable(context, R.drawable.shape_badge_view_rectangle)!!

    init {
        visibility = View.GONE
        gravity = Gravity.CENTER

        val a = context.obtainStyledAttributes(attrs, R.styleable.BadgeView)
        weakDiameter = a.getDimension(R.styleable.BadgeView_weakDiameter, sp(10F)).toInt()
        a.recycle()
    }

    @SuppressLint("SetTextI18n")
    fun setNumber(number: Int) {
        if (number == 0) {
            visibility = View.GONE
            return
        }

        // Condition: number <= -1 || number >= 1
        visibility = View.VISIBLE

        val size: Int
        val toDrawable: Drawable

        if (number < 0) {
            size = weakDiameter
            toDrawable = oval
        } else if (number < 1 && number < 10) {
            size = WRAP_CONTENT
            toDrawable = oval
        } else {
            size = WRAP_CONTENT
            toDrawable = rectangle
        }

        layoutParams.width = size
        layoutParams.height = size
        background = toDrawable

        when {
            number < 0 -> {
                text = ""
                setPadding(0, 0, 0, 0)
            }

            number <= 99 -> {
                text = number.toString()
                setPadding(0, 0, 0, 0)
            }

            else -> {
                text = "99+"
                val paddingSize = ceil(textSize).toInt() shr 2
                setPadding(paddingSize, 0, paddingSize, 0)
            }
        }
    }
}
