package com.strategair.strategy

import androidx.multidex.MultiDexApplication
import com.strategair.strategy.common.CommonManager

class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        CommonManager.init(this)
    }
}
