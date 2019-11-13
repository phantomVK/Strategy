package com.strategair.strategy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.strategair.common.component.WebViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        skip.setOnClickListener { WebViewActivity.startActivity(this, "https://www.baidu.com") }
    }
}
