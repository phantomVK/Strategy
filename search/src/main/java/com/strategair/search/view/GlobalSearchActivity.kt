package com.strategair.search.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.strategair.common.component.ImmersiveActivity
import com.strategair.search.R
import kotlinx.android.synthetic.main.activity_global_search.*

class GlobalSearchActivity : ImmersiveActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_global_search)
        cancel.setOnClickListener { finish() }
    }

    companion object {
        fun startActivity(activity: AppCompatActivity) {
            Intent(activity, GlobalSearchActivity::class.java)
                .run { activity.startActivity(this) }
        }
    }

    // Override super.initToolbar()
    override fun initToolbar() {}
}
