package com.strategair.strategy.common.image

import com.strategair.strategy.common.image.implement.ContentLoader
import com.strategair.strategy.common.image.implement.UserAvatar

object ImageLoader {

    @JvmStatic
    val user = UserAvatar

    @JvmStatic
    val content = ContentLoader
}
