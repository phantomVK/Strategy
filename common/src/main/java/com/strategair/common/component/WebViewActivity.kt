package com.strategair.common.component

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.strategair.common.R

class WebViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
    }

    companion object {
        private const val EXTRA_URL = "URL"
        private const val EXTRA_TITLE = "TITLE"

        fun startActivity(activity: Activity, url: String, title: String) {
            Intent(activity, WebViewActivity::class.java)
                .putExtra(EXTRA_URL, url)
                .putExtra(EXTRA_TITLE, title)
                .run { activity.startActivity(this) }
        }
    }
}
