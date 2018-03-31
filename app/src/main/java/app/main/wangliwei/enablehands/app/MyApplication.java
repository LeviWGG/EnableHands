package app.main.wangliwei.enablehands.app;


import android.app.Application;
import android.content.Context;

import com.orhanobut.hawk.Hawk;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import app.main.wangliwei.baselib.utils.BaseUtils;

public class MyApplication extends Application {
    private static Context context;
    private RefWatcher refWatcher;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
//        refWatcher = LeakCanary.install(this);

        context = super.getApplicationContext();

        //key value存储器初始化
        Hawk.init(context).build();

        //BaseUtils 初始化
        BaseUtils.init(context);
    }

    public static Context getMyContext() {
        return context;
    }

    public static RefWatcher getRefWatcher(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}
