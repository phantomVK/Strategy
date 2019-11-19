package com.strategair.strategy.me.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.strategair.strategy.common.component.ImmersiveActivity
import com.strategair.strategy.me.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingsActivity : ImmersiveActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        privacy.setOnClickListener { PrivacyActivity.startActivity(this) }
        general.setOnClickListener { GeneralActivity.startActivity(this) }
        aboutUs.setOnClickListener { AboutActivity.startActivity(this) }
        feedback.setOnClickListener { FeedbackActivity.startActivity(this) }
    }

    companion object {
        @JvmStatic
        fun startActivity(context: Context) {
            Intent(context, SettingsActivity::class.java)
                .run { context.startActivity(this) }
        }
    }
}
