package com.strategair.common.image

import com.strategair.common.image.implement.ContentLoader
import com.strategair.common.image.implement.UserAvatar

object ImageLoader {

    @JvmStatic
    val user = UserAvatar

    @JvmStatic
    val content = ContentLoader
}