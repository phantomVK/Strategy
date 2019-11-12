package com.strategair.common.component

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.phantomvk.slideback.SlideActivity
import com.strategair.common.R

open class BaseActivity : SlideActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!slideBackDisable()) overridePendingTransition(R.anim.slide_in_right, 0)
    }

    override fun onContentChanged() {
        super.onContentChanged()
        initToolbar()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    override fun finish() {
        super.finish()
        if (!slideBackDisable()) overridePendingTransition(0, R.anim.slide_out_right)
    }

    protected open fun initToolbar() {
        findViewById<Toolbar>(R.id.toolbar)?.apply {
            setSupportActionBar(this)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}
