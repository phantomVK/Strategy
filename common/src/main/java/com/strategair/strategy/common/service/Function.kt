package com.strategair.strategy.common.service

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
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

fun Context.tintDrawable(@DrawableRes id: Int, @ColorInt color: Int): Drawable {
    return ContextCompat.getDrawable(this, id)!!.tintDrawable(color)
}

fun Context.dp(value: Int) = (value * resources.displayMetrics.density).toInt()
fun Context.dp(value: Float) = value * resources.displayMetrics.density
fun Context.sp(value: Int) = (value * resources.displayMetrics.scaledDensity).toInt()
fun Context.sp(value: Float) = value * resources.displayMetrics.scaledDensity

fun View.dp(value: Int) = (value * resources.displayMetrics.density).toInt()
fun View.dp(value: Float) = value * resources.displayMetrics.density
fun View.sp(value: Int) = (value * resources.displayMetrics.scaledDensity).toInt()
fun View.sp(value: Float) = value * resources.displayMetrics.scaledDensity
