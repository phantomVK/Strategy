package com.strategair.common;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tencent.smtt.sdk.QbSdk;

public class CommonManager {

    public static void init(Application application) {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);

        QbSdk.initX5Environment(application, null);
    }
}
