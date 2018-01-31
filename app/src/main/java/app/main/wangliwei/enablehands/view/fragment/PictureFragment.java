package app.main.wangliwei.enablehands.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseFragment;

public class PictureFragment extends BaseFragment {


    public PictureFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_picture;
    }

}
