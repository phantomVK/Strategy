package com.strategair.common.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText

class ClearableEditText
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                          defStyle: Int = android.R.attr.editTextStyle)
    : AppCompatEditText(context, attrs, defStyle), View.OnFocusChangeListener, TextWatcher {

    private lateinit var mDrawableEnd: Drawable

    init {
        init(context, attrs, defStyle)
    }

    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
    }

    override fun afterTextChanged(s: Editable?) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }

    fun setIconVisible(visible: Boolean) {
        onFocusChangeListener = this
        addTextChangedListener(this)
    }
}