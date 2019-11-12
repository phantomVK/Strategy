package com.strategair.common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tencent.mmkv.MMKV;
import com.tencent.smtt.sdk.QbSdk;

public class CommonManager {
    /**
     * Initialize third-party libraries for Common module.
     *
     * @param application {@link Application} instance
     */
    public static void init(Application application) {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);
        MMKV.initialize(application);
        QbSdk.initX5Environment(application, null);
    }
}
