package com.strategair.strategy

import android.os.Bundle
import android.view.View.*
import androidx.appcompat.app.AppCompatActivity
import com.strategair.common.component.WebViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = (SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or SYSTEM_UI_FLAG_FULLSCREEN
                or SYSTEM_UI_FLAG_LAYOUT_STABLE)
        setContentView(R.layout.activity_main)

        skip.setOnClickListener { WebViewActivity.startActivity(this, "https://www.qq.com") }
    }
}
