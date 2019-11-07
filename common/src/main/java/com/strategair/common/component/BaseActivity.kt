package com.strategair.common.component

import android.view.MenuItem
import com.phantomvk.slideback.SlideActivity

open class BaseActivity : SlideActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else super.onOptionsItemSelected(item)
    }
}
