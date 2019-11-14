package com.strategair.strategy.common.utils

import java.math.BigDecimal

fun formatFileSize(size: Long): String {
    require(size >= 0) { "size must be positive." }
    if (size == 0L) return "0B"

    val kiloByte = (size / 1024f).toDouble()
    if (kiloByte < 1) {
        return size.toString() + "B"
    }

    val megaByte = kiloByte / 1024
    if (megaByte < 1) {
        return BigDecimal(kiloByte.toString())
            .setScale(0, BigDecimal.ROUND_HALF_UP)
            .toPlainString() + "KB"
    }

    val gigaByte = megaByte / 1024
    if (gigaByte < 1) {
        return BigDecimal(megaByte.toString())
            .setScale(2, BigDecimal.ROUND_HALF_UP)
            .toPlainString() + "MB"
    }

    val teraBytes = gigaByte / 1024
    return if (teraBytes < 1) {
        BigDecimal(gigaByte.toString())
            .setScale(2, BigDecimal.ROUND_HALF_UP)
            .toPlainString() + "GB"
    } else {
        BigDecimal(teraBytes)
            .setScale(2, BigDecimal.ROUND_HALF_UP)
            .toPlainString() + "TB"
    }
}
