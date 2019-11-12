package com.strategair.common.service

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.graphics.drawable.DrawableCompat

fun Drawable.tintDrawable(colors: ColorStateList): Drawable {
    val d = DrawableCompat.wrap(this.mutate())
    DrawableCompat.setTintList(d, colors)
    return d
}

fun Drawable.tintDrawable(@ColorInt color: Int): Drawable {
    val d = DrawableCompat.wrap(this.mutate())
    DrawableCompat.setTint(d, color)
    return d
}

internal fun Context.dp(value: Int) = (value * resources.displayMetrics.density).toInt()
internal fun Context.dp(value: Float) = value * resources.displayMetrics.density
internal fun Context.sp(value: Int) = (value * resources.displayMetrics.scaledDensity).toInt()
internal fun Context.sp(value: Float) = value * resources.displayMetrics.scaledDensity

internal fun View.dp(value: Int) = (value * resources.displayMetrics.density).toInt()
internal fun View.dp(value: Float) = value * resources.displayMetrics.density
internal fun View.sp(value: Int) = (value * resources.displayMetrics.scaledDensity).toInt()
internal fun View.sp(value: Float) = value * resources.displayMetrics.scaledDensity
