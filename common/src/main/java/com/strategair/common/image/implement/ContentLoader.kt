package com.strategair.common.image.implement

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.strategair.common.image.interfaces.IContentImage

object ContentLoader : IContentImage {

    override fun loadUrl(url: String, view: ImageView) {
        Glide.with(view.context)
            .asBitmap()
            .load(url)
            .apply(CONTENT_OPTS)
            .transition(CROSS_FADE_OPTS)
            .into(view)
    }

    override fun loadCaptcha(url: String, view: ImageView) {
        val opts = RequestOptions()
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)

        Glide.with(view.context)
            .asBitmap()
            .load(url)
            .apply(opts)
            .transition(CROSS_FADE_OPTS)
            .into(view)
    }

    override fun loadDrawable(@DrawableRes resId: Int, view: ImageView) {
        Glide.with(view.context)
            .asBitmap()
            .load(resId)
            .apply(CONTENT_OPTS)
            .transition(CROSS_FADE_OPTS)
            .into(view)
    }

    // RequestOptions for image of contents.
    @JvmStatic
    private val CONTENT_OPTS = RequestOptions()

    // BitmapTransitionOptions.withCrossFade()
    @JvmStatic
    private val CROSS_FADE_OPTS = BitmapTransitionOptions.withCrossFade()
}