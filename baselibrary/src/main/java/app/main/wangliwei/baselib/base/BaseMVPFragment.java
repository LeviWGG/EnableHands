package app.main.wangliwei.baselib.base;

/**
 * Created by wlw on 2018/4/2.
 */

public abstract class BaseMVPFragment<P extends BasePresenter> extends BaseCompatFragment {
    /**
     * presenter 具体类型由子类决定
     */
    public P mPresenter;

    public abstract P initPresenter();

    @Override
    protected void initData() {
        super.initData();
        this.mPresenter = initPresenter();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        /** Fragment 销毁时解除 presenter 绑定 */
        if(mPresenter != null) {
            mPresenter.dettachMV();
        }
    }
}
