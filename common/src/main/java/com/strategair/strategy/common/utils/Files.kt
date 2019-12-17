package com.strategair.strategy.common.utils

import java.math.BigDecimal
import kotlin.math.abs
import kotlin.math.ln
import kotlin.math.pow

/**
 * @param size number in bytes.
 */
fun formatFileSize(size: Double): String {
    require(size >= 0) { "'size: Long' must be positive." }
    if (size == 0.0) return "0B"

    val kiloByte = (size / 1024)
    if (kiloByte < 1) {
        return "${size.toInt()}B"
    }

    val megaByte = kiloByte / 1024
    if (megaByte < 1) {
        return BigDecimal(kiloByte)
            .setScale(0, BigDecimal.ROUND_HALF_UP)
            .toPlainString() + "KB"
    }

    val gigaByte = megaByte / 1024
    if (gigaByte < 1) {
        return BigDecimal(megaByte)
            .setScale(1, BigDecimal.ROUND_HALF_UP)
            .toPlainString() + "MB"
    }

    val teraBytes = gigaByte / 1024
    return if (teraBytes < 1) {
        BigDecimal(gigaByte)
            .setScale(1, BigDecimal.ROUND_HALF_UP)
            .toPlainString() + "GB"
    } else {
        BigDecimal(teraBytes)
            .setScale(1, BigDecimal.ROUND_HALF_UP)
            .toPlainString() + "TB"
    }
}

@Strictfp
fun readableByteCount(rawBytes: Long, si: Boolean): String {
    var bytes = rawBytes
    val unit = if (si) 1000 else 1024
    val absBytes = if (bytes == Long.MIN_VALUE) Long.MAX_VALUE else abs(bytes)
    if (absBytes < unit) return "$bytes B"
    var exp = (ln(absBytes.toDouble()) / ln(unit.toDouble())).toInt()
    val th = (unit.toDouble().pow(exp.toDouble()) * (unit - 0.05)).toLong()
    if (exp < 6 && absBytes >= th - (if (th and 0xfff == 0xd00L) 52 else 0)) exp++
    val pre = (if (si) "kMGTPE" else "KMGTPE")[exp - 1].toString() + if (si) "" else "i"
    if (exp > 4) {
        bytes /= unit.toLong()
        exp -= 1
    }
    return String.format("%.1f %sB", bytes / unit.toDouble().pow(exp.toDouble()), pre)
}
