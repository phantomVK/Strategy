package com.strategair.common.image.interfaces

import android.widget.ImageView
import androidx.annotation.DrawableRes

interface IContentImage {
    // Load image into ImageView by url.
    fun loadUrl(url: String, view: ImageView)

    // Load captcha into ImageView by url.
    fun loadCaptcha(url: String, view: ImageView)

    // Load image into ImageView by DrawableRes.
    fun loadDrawable(@DrawableRes resId: Int, view: ImageView)
}
