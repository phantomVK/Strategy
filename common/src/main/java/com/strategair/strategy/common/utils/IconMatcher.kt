package com.strategair.strategy.common.utils

import com.strategair.strategy.common.R
import java.util.*

object IconMatcher {
    /**
     * Get drawable resource id by type string.
     */
    @JvmStatic
    fun getResId(type: String) = when (type.toLowerCase(Locale.ROOT)) {
        "doc", "docx" -> R.drawable.icon_file_doc
        "xls", "xlsx" -> R.drawable.icon_file_xls
        "ppt", "pptx" -> R.drawable.icon_file_ppt
        "key" -> R.drawable.icon_file_key
        "number" -> R.drawable.icon_file_numebers
        "pages" -> R.drawable.icon_file_pages
        "7z" -> R.drawable.icon_file_7z
        "zip", "rar" -> R.drawable.icon_file_zip
        "pdf" -> R.drawable.icon_file_pdf
        "jpg", "jpeg", "png", "bmp" -> R.drawable.icon_file_jpg
        "amr", "mp3" -> R.drawable.icon_file_voice
        "mp4" -> R.drawable.icon_file_video
        "txt" -> R.drawable.icon_file_txt
        else -> R.drawable.icon_file_unknown
    }
}
