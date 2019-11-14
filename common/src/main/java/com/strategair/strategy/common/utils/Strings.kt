package com.strategair.strategy.common.utils

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.annotation.ColorInt

fun highlight(builder: SpannableString, source: String, key: String, @ColorInt color: Int): CharSequence {
    var start = source.indexOf(key, 0, true)
    val length = key.length
    while (start > -1) {
        val end = start + length
        val span = ForegroundColorSpan(color)
        builder.setSpan(span, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        start = source.indexOf(key, end, true)
    }
    return builder
}

fun highlight(source: String, key: String, @ColorInt color: Int): CharSequence {
    return highlight(SpannableString(source), source, key, color)
}

fun highlight(source: String, keys: Collection<String>, @ColorInt color: Int): CharSequence {
    val builder = SpannableString(source)
    keys.forEach { key -> highlight(builder, source, key, color) }
    return builder
}
