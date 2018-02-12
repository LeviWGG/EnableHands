package app.main.wangliwei.enablehands.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseActivity;

public class SplashActivity extends BaseActivity {
    private Handler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    private void initView() {
        uiHandler = new Handler(Looper.getMainLooper());
        uiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
