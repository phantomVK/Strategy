package com.strategair.strategy

import androidx.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter

class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}
