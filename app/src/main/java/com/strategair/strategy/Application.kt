package com.strategair.strategy

import android.os.StrictMode
import androidx.multidex.MultiDexApplication
import com.strategair.strategy.common.CommonManager

class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        CommonManager.init(this)
    }

    private fun strictMode() {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder()
            .detectAll()
            .build())

        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder()
            .detectAll()
            .build())
    }
}
