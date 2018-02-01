package app.main.wangliwei.enablehands.view.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseFragment;
import app.main.wangliwei.enablehands.bean.Picture;
import app.main.wangliwei.enablehands.view.adapter.PictureAdapter;
import butterknife.BindView;

public class PictureFragment extends BaseFragment {
    private boolean isAdded = false;
    private View view;
    private String url = "http://img5.duitang.com/uploads/item/201512/31/20151231204455_AFLZG.jpeg";
    private PictureAdapter adapter;

    @BindView(R.id.recycle_picture)
    RecyclerView mRecyclerView;


    public PictureFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = super.onCreateView(inflater,container,savedInstanceState);
        //避免重复绘制View
        if(!isAdded) {
            initView();
            isAdded = true;
        }

        return view;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_picture;
    }

    private void initView() {
        List<Picture> list = new ArrayList<>();
        for(int i=0;i<10;i++) {
            list.add(new Picture(0,url,"测试标题",""));
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PictureAdapter(getActivity(),this,list);
        mRecyclerView.setAdapter(adapter);
    }

}
