package app.main.wangliwei.baselib.utils;

import android.content.Context;

/**
 * Created by wlw on 2018/3/31.
 */

public final class BaseUtils {
    private static Context application;

    public static void init(Context context) {
        application = context;
    }

    public static Context getApp() {
        if(null != application)return application;
        throw new NullPointerException("u should init first");
    }
}
