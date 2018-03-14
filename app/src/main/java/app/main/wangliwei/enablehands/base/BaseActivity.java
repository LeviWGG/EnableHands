package app.main.wangliwei.enablehands.base;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;
    private int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            //|View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        unbinder = ButterKnife.bind(this);
        initData();
        setTransParent();
    }

    public abstract int getLayoutId();

    protected void initData() {}

    /**
     * 携带数据的页面跳转
     * @param clz 要跳转的Activity
     * @param bundle 数据包装
     */
    public void startActivity(@NonNull Class<?> clz, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this,clz);
        if(bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 携带数据跳转编辑界面，返回数据
     * @param clz
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(@NonNull Class<?> clz, @Nullable Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this,clz);
        if(bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent,requestCode);
    }

    private void setTransParent(){
        getWindow().getDecorView().setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        //getWindow().setNavigationBarColor(Color.TRANSPARENT);
        getSupportActionBar().hide();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }
}
