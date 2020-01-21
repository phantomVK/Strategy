package com.strategair.strategy.common.utils

import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * This function returns the calculated in-between value for a color
 * given integers that represent the start and end values in the four
 * bytes of the 32-bit int. Each channel is separately linearly interpolated
 * and the resulting calculated values are recombined into the return value.
 *
 * @param fraction   The fraction from the starting to the ending values
 * @param startValue A 32-bit int value representing colors in the
 * separate bytes of the parameter
 * @param endValue   A 32-bit int value representing colors in the
 * separate bytes of the parameter
 * @return A value that is calculated to be the linearly interpolated
 * result, derived by separating the start and end values into separate
 * color channels and interpolating each one separately, recombining the
 * resulting values in the same way.
 */
fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
    val startA = (startValue shr 24 and 0xff) / 255.0
    var startR = (startValue shr 16 and 0xff) / 255.0
    var startG = (startValue shr 8 and 0xff) / 255.0
    var startB = (startValue and 0xff) / 255.0
    val endA = (endValue shr 24 and 0xff) / 255.0
    var endR = (endValue shr 16 and 0xff) / 255.0
    var endG = (endValue shr 8 and 0xff) / 255.0
    var endB = (endValue and 0xff) / 255.0

    // convert from sRGB to linear
    startR = startR.pow(2.2)
    startG = startG.pow(2.2)
    startB = startB.pow(2.2)
    endR = endR.pow(2.2)
    endG = endG.pow(2.2)
    endB = endB.pow(2.2)

    // compute the interpolated color in linear space
    var a = startA + fraction * (endA - startA)
    var r = startR + fraction * (endR - startR)
    var g = startG + fraction * (endG - startG)
    var b = startB + fraction * (endB - startB)

    // convert back to sRGB in the [0..255] range
    a *= 255
    r = r.pow(1.0 / 2.2) * 255
    g = g.pow(1.0 / 2.2) * 255
    b = b.pow(1.0 / 2.2) * 255
    return a.roundToInt() shl 24 or (r.roundToInt() shl 16) or (g.roundToInt() shl 8) or b.roundToInt()
}