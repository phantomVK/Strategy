package com.strategair.strategy.common.utils

import java.math.BigDecimal

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
