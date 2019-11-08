package com.strategair.strategy

import android.os.Bundle
import com.strategair.common.component.BaseActivity
import com.strategair.common.component.WebViewActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        WebViewActivity.startActivity(this, "https://www.baidu.com")
    }

    override fun slideBackDisable() = true
}
