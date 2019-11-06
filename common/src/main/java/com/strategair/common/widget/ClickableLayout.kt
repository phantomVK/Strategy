package com.strategair.common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.strategair.common.R

class ClickableLayout
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : RelativeLayout(context, attrs, defStyle) {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_clickable_icons, this)

        val divider = findViewById<View>(R.id.divider)
        val iconStart = findViewById<AppCompatImageView>(R.id.iconStart)
        val iconEnd = findViewById<AppCompatImageView>(R.id.iconEnd)
        val textView = findViewById<AppCompatTextView>(R.id.text)

        val a = context.obtainStyledAttributes(attrs, R.styleable.ClickableLayout)
        if (a.getBoolean(R.styleable.ClickableLayout_align_text_start, false)) {
            val p = divider.layoutParams as LayoutParams
            p.addRule(ALIGN_START, R.id.text)
            divider.layoutParams = p
        }
        textView.text = a.getString(R.styleable.ClickableLayout_text)
        iconStart.setImageResource(a.getResourceId(R.styleable.ClickableLayout_icon_start, 0))
        iconEnd.setImageResource(a.getResourceId(R.styleable.ClickableLayout_icon_end, 0))
        a.recycle()
    }
}
