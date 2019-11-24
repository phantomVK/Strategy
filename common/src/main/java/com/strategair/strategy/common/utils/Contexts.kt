@file:Suppress("NOTHING_TO_INLINE")

package com.strategair.strategy.common.utils

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Point
import android.view.WindowManager

/**
 * Get application name by packageName.
 */
fun Context.getApplicationLabel(packageName: String): String {
    val i = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
    return packageManager.getApplicationLabel(i).split('.', ignoreCase = true).last()
}

/**
 * Get the size of the display, in pixels.
 *
 * @param outSize A {@link Point} object to receive the size information.
 */
inline fun Context.screenSize(outSize: Point) {
    (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getSize(outSize)
}

/**
 * The absolute width of the available display size in pixels.
 */
inline fun Context.widthPixels() = resources.displayMetrics.widthPixels

/**
 * The absolute height of the available display size in pixels.
 */
inline fun Context.heightPixels() = resources.displayMetrics.heightPixels
