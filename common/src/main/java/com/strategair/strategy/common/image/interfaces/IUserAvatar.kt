package com.strategair.strategy.common.image.interfaces

import android.widget.ImageView

interface IUserAvatar {

    fun loadUrl(url: String, view: ImageView)

    fun loadUserId(userId: String, view: ImageView)
}
