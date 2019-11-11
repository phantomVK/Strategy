package com.strategair.strategy

import android.os.Bundle
import android.view.View.*
import androidx.appcompat.app.AppCompatActivity
import com.strategair.search.view.GlobalSearchActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        skip.setOnClickListener { GlobalSearchActivity.startActivity(this) }
    }

    private fun fullscreen() {
        window.decorView.systemUiVisibility = (SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or SYSTEM_UI_FLAG_FULLSCREEN
                or SYSTEM_UI_FLAG_LAYOUT_STABLE)
    }
}
