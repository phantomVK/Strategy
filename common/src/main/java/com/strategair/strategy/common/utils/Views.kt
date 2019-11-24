package com.strategair.strategy.common.utils

import android.content.Context
import android.text.TextUtils
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

fun Toolbar.setTitleEllipsize(where: TextUtils.TruncateAt) {
    try {
        val f = Toolbar::class.java.getDeclaredField("mTitleTextView")
        f.isAccessible = true
        (f.get(this) as TextView).ellipsize = where
    } catch (ignore: Exception) {
    }
}

fun EditText.showSoftInput() {
    (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        .showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}