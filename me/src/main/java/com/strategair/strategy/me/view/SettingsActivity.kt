package com.strategair.strategy.me.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.strategair.strategy.common.component.ImmersiveActivity
import com.strategair.strategy.me.R

class SettingsActivity : ImmersiveActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
    }

    companion object {
        fun startActivity(context: Context) {
            Intent(context, SettingsActivity::class.java)
                .run { context.startActivity(this) }
        }
    }
}
