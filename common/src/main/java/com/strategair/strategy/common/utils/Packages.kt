package com.strategair.strategy.common.utils

import android.content.Context
import android.content.pm.PackageManager.GET_META_DATA

fun Context.getApplicationLabel(packageName: String): String? {
    return try {
        val i = packageManager.getApplicationInfo(packageName, GET_META_DATA)
        packageManager.getApplicationLabel(i).split('.', ignoreCase = true).last()
    } catch (ignore: Exception) {
        null
    }
}
