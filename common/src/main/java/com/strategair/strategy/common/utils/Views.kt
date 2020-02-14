package com.strategair.strategy.common.utils

import android.app.Activity
import android.content.Context
import android.graphics.PixelFormat
import android.os.IBinder
import android.text.TextUtils
import android.view.View
import android.view.WindowManager.LayoutParams
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.ColorInt
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

fun Activity.addMask(token: IBinder, @ColorInt color: Int): View {
    val p = LayoutParams()
    p.width = LayoutParams.MATCH_PARENT
    p.height = LayoutParams.MATCH_PARENT
    p.type = LayoutParams.TYPE_APPLICATION_PANEL
    p.format = PixelFormat.TRANSLUCENT
    p.token = token

    val v = View(this)
    v.setBackgroundColor(color)
    v.fitsSystemWindows = false
    windowManager.addView(v, p)
    return v
}