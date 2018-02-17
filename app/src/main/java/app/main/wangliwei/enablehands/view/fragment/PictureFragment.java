package app.main.wangliwei.enablehands.view.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseFragment;
import app.main.wangliwei.enablehands.bean.Weixin;
import app.main.wangliwei.enablehands.presenter.IPictureContract;
import app.main.wangliwei.enablehands.presenter.PicturePresenterImp;
import app.main.wangliwei.enablehands.view.adapter.WeixinAdapter;
import butterknife.BindView;

public class PictureFragment extends BaseFragment implements IPictureContract.IPictureView {
    private boolean isAdded = false;
    private View view;
    private String url = "http://img5.duitang.com/uploads/item/201512/31/20151231204455_AFLZG.jpeg";
    private WeixinAdapter adapter;
    private IPictureContract.IPicturePresenter iPicturePresenter;

    @BindView(R.id.recycle_picture)
    RecyclerView mRecyclerView;


    public PictureFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = super.onCreateView(inflater,container,savedInstanceState);
        //避免重复绘制View
        if(!isAdded) {
            iPicturePresenter = new PicturePresenterImp(this);
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
//        List<Picture> list = new ArrayList<>();
//        for(int i=0;i<10;i++) {
//            list.add(new Picture(0,url,"测试标题",""));
//        }
        iPicturePresenter.getWeixinNews();
    }

    @Override
    public void scrollToTop() {
        mRecyclerView.smoothScrollToPosition(0);
    }

    @Override
    public void setWeixinNews(List<Weixin.ResultBean.ListBean> list) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(new WeakReference<>(getActivity()).get()));
        adapter = new WeixinAdapter(new WeakReference<>(getActivity()).get(),this,list);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        iPicturePresenter.onDestroy();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
