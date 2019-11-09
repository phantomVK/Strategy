package com.strategair.strategy

import androidx.multidex.MultiDexApplication
import com.strategair.common.CommonManager

class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        CommonManager.init(this)
    }
}
