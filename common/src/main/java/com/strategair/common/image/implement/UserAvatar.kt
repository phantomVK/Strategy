package com.strategair.common.image.implement

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.strategair.common.image.interfaces.IUserAvatar

object UserAvatar : IUserAvatar {

    override fun loadUrl(url: String, view: ImageView) {
        Glide.with(view.context)
            .asBitmap()
            .load(url)
            .apply(USER_AVATAR_OPTS)
            .transition(CROSS_FADE_OPTS)
            .into(view)
    }

    override fun loadUserId(userId: String, view: ImageView) {
    }

    // RequestOptions for user avatars.
    @JvmStatic
    private val USER_AVATAR_OPTS = RequestOptions().priority(Priority.LOW).centerCrop()

    // BitmapTransitionOptions.withCrossFade()
    @JvmStatic
    private val CROSS_FADE_OPTS = BitmapTransitionOptions.withCrossFade()
}
