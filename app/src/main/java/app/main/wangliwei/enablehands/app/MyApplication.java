package app.main.wangliwei.enablehands.app;


import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context context;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        context = super.getApplicationContext();
    }

    public static Context getMyContext() {
        return context;
    }
}
