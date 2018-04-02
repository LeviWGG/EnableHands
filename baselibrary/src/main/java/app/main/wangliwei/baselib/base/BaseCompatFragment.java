package app.main.wangliwei.baselib.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.main.wangliwei.baselib.utils.ViewUtil;
import app.main.wangliwei.baselib.widgets.WaitProgressDialog;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by wlw on 2018/4/2.
 */

public abstract class BaseCompatFragment extends BaseFragment {
    protected WaitProgressDialog mWaitProgressDialog;
    private View view;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return attachToSwipeBack(view);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * 传递Fragment的布局ID
     *
     * @return layout id
     */
    public abstract int getLayoutId();

    /**
     * 初始化框架内的内容
     */
    public abstract void initView(@Nullable Bundle savedInstanceState);

    /**
     * 懒加载框架内的内容
     */
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initView(savedInstanceState);
    }

    /**
     * 准备数据
     */
    protected void initData() {
        mWaitProgressDialog = new WaitProgressDialog(getActivity());
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

    protected void showProgressDialog(int id) {
        this.showProgressDialog(ViewUtil.getResourceString(id));
    }

    /**
     * 隐藏加载提示框
     */
    protected void hideProgressDialog() {
        if (mWaitProgressDialog != null && mWaitProgressDialog.isShowing()) {
            mWaitProgressDialog.dismiss();
        }
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

    @Override
    public void startWithPop(ISupportFragment toFragment) {
        if (getParentFragment() == null) {
            super.startWithPop(toFragment);
            return;
        }
        ((BaseFragment) getParentFragment()).startWithPop(toFragment);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
//        /** LeakCanary 监听 Fragment */
//        RefWatcher refWatcher = BitkerApp.getRefWatcher(getActivity());
//        refWatcher.watch(this);
    }
}
