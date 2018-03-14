package app.main.wangliwei.enablehands.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private View view;
    private Unbinder unbinder;
    private boolean isVisibleToUser = false;
    private boolean isInited = false;
    private boolean isPrepareView = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null) {
            view = inflater.inflate(getLayoutId(),container,false);
        }
        unbinder = ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepareView = true;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyInitView();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        lazyInitView();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    private void lazyInitView() {
        if(!isInited && isVisibleToUser && isPrepareView) {
            isInited = true;
            initData();
            initView();
        }
    }

    protected void initData() {}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
//        RefWatcher refWatcher = MyApplication.getRefWatcher(getActivity());
//        refWatcher.watch(this);
    }
}
