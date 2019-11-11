package com.strategair.strategy.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.strategair.strategy.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    companion object {
        fun startActivity(activity: AppCompatActivity) {
            Intent(activity, LoginActivity::class.java)
                .run { activity.startActivity(this) }
        }
    }
}
