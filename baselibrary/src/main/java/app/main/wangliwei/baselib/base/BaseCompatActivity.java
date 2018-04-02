package app.main.wangliwei.baselib.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import app.main.wangliwei.baselib.widgets.WaitProgressDialog;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wlw on 2018/4/2.
 */

public abstract class BaseCompatActivity extends BaseActivity {
    protected WaitProgressDialog mWaitProgressDialog;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        initData();
    }

    public abstract int getLayoutId();

    protected void initData() {
        mWaitProgressDialog = new WaitProgressDialog(this);
    }

    /**
     * 显示加载提示框
     *
     * @param msg 加载框内文字
     */
    protected void showProgressDialog(String msg) {
        if (mWaitProgressDialog == null) return;
        if (mWaitProgressDialog.isShowing()) {
            mWaitProgressDialog.dismiss();
        }
        mWaitProgressDialog.setMessage(msg);
        mWaitProgressDialog.show();
    }

    /**
     * 隐藏加载提示框
     */
    protected void hideProgressDialog() {
        if (mWaitProgressDialog != null && mWaitProgressDialog.isShowing()) {
            mWaitProgressDialog.dismiss();
        }
    }

    /**
     * 携带数据的页面跳转
     *
     * @param clz    要跳转的Activity
     * @param bundle 数据包装
     */
    public void startActivity(@NonNull Class<?> clz, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 携带数据跳转编辑界面，返回数据
     *
     * @param clz         要跳转的Activity
     * @param bundle      数据包装
     * @param requestCode requestCode
     */
    public void startActivityForResult(@NonNull Class<?> clz, @Nullable Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    // 对于SwipeBackActivity有下面控制SwipeBack优先级的方法:

    /**
     * 限制SwipeBack的条件,默认栈内Fragment数 <= 1时 , 优先滑动退出Activity , 而不是Fragment
     * <p>
     * 可以通过复写该方法, 自由控制优先级
     *
     * @return true: Activity优先滑动退出;  false: Fragment优先滑动退出
     */
    @Override
    public boolean swipeBackPriority() {
        return super.swipeBackPriority();
        // 下面是默认实现:
        // return getSupportFragmentManager().getBackStackEntryCount() <= 1;
    }
}
