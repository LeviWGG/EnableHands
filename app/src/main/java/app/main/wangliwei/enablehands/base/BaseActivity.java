package app.main.wangliwei.enablehands.base;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;
    private int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        unbinder = ButterKnife.bind(this);
        setTransParent();
    }

    public abstract int getLayoutId();

    private void setTransParent(){
        getWindow().getDecorView().setSystemUiVisibility(option);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);
        getSupportActionBar().hide();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }
}
