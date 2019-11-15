package com.strategair.strategy.common

import com.strategair.strategy.common.utils.formatFileSize
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_formatFileSize() {
        assertEquals("0B", formatFileSize(0.0))
        assertEquals("110B", formatFileSize(110.0))
        assertEquals("1KB", formatFileSize(1024.0))
        assertEquals("100KB", formatFileSize(102400.0))
        assertEquals("1.0MB", formatFileSize(1024 * 1024.0))
        assertEquals("1.1MB", formatFileSize(1024 * (1024 + 100.0)))
        assertEquals("102.0GB", formatFileSize(1024 * 1024 * 1024 * 102.0))
        assertEquals("1.0TB", formatFileSize(1024 * 1024 * 1024 * 1024.0))
        assertEquals("10.0TB", formatFileSize(1024 * 1024 * 1024 * 1024.0 * 10))
    }
}
