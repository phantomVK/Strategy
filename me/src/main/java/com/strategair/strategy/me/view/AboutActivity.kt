package com.strategair.strategy.me.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.strategair.strategy.common.component.ImmersiveActivity
import com.strategair.strategy.me.R

class AboutActivity : ImmersiveActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    companion object {
        @JvmStatic
        fun startActivity(context: Context) {
            Intent(context, AboutActivity::class.java)
                .run { context.startActivity(this) }
        }
    }
}
