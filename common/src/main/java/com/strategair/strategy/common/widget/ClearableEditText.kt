package com.strategair.strategy.common.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.res.ResourcesCompat
import com.strategair.strategy.common.R
import com.strategair.strategy.common.service.dp

class ClearableEditText
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = android.R.attr.editTextStyle)
    : AppCompatEditText(context, attrs, defStyle), View.OnFocusChangeListener, TextWatcher {

    private var mDrawableStart: Drawable? = null
    private var mDrawableEnd: Drawable? = null
    private var mDrawableStartVisible = 0

    init {
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.ClearableEditText, defStyle, 0)
        mDrawableStartVisible = a.getInteger(R.styleable.ClearableEditText_drawableStartVisible, View.GONE)
        a.recycle()

        val padding = dp(5F).toInt()

        if (mDrawableStartVisible == View.VISIBLE) {
            mDrawableStart = compoundDrawables[0]
                ?: ResourcesCompat.getDrawable(resources, R.drawable.icon_search, null)
                    ?.apply { setBounds(0, 0, intrinsicWidth + padding, intrinsicHeight + padding) }
        }

        mDrawableEnd = compoundDrawables[2]
            ?: ResourcesCompat.getDrawable(resources, R.drawable.icon_clear, null)
                ?.apply { setBounds(0, 0, intrinsicWidth + padding, intrinsicHeight + padding) }

        setCompoundDrawables(mDrawableStart, null, null, null)

        onFocusChangeListener = this
        addTextChangedListener(this)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP) {
            val drawableEnd = mDrawableEnd
            if (drawableEnd != null) {
                val eventX = event.x
                val touchEnd = width - paddingRight
                val touchStart = touchEnd - drawableEnd.intrinsicWidth
                if (touchStart <= eventX && eventX <= touchEnd) setText("")
            }
        }

        return super.onTouchEvent(event)
    }

    override fun onFocusChange(v: View, hasFocus: Boolean) {
        setDrawableEndVisible(hasFocus)
    }

    override fun afterTextChanged(s: Editable) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
        setDrawableEndVisible(!text.isNullOrBlank())
    }

    private fun setDrawableEndVisible(visible: Boolean) {
        val end = if (visible) mDrawableEnd else null
        setCompoundDrawables(mDrawableStart, null, end, null)
    }
}
