package app.main.wangliwei.enablehands.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.lang.ref.WeakReference;
import java.util.List;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseFragment;
import app.main.wangliwei.enablehands.bean.Weixin;
import app.main.wangliwei.enablehands.presenter.IPictureContract;
import app.main.wangliwei.enablehands.presenter.PicturePresenterImp;
import app.main.wangliwei.enablehands.view.WebDetailActivity;
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

    @BindView(R.id.layout_weixin_fresh)
    SmartRefreshLayout smartRefreshLayout;


    public PictureFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = super.onCreateView(inflater,container,savedInstanceState);
        //避免重复绘制View
        if(!isAdded) {
            iPicturePresenter = new PicturePresenterImp(this);
            //initView();
            isAdded = true;
        }

        return view;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_picture;
    }

    @Override
    public void initView() {
//        List<Picture> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(new Picture(0, url, "测试标题", ""));
//        }
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                smartRefreshLayout.finishLoadmore(2000);
                iPicturePresenter.getWeixinNews();
            }
        });

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
        adapter.setItemListener(new WeixinAdapter.ItemListener() {
            @Override
            public void onClick(View view) {
                if(((String)view.getTag()).equals("")) {
                    return;
                }
                Log.d("item","url: "+view.getTag());
                Bundle bundle = new Bundle();
                bundle.putString("URL",(String)view.getTag());
                Intent intent = new Intent(getActivity(),WebDetailActivity.class);
                intent.putExtras(bundle);
                startActivity(intent,bundle);
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void loadMore(List<Weixin.ResultBean.ListBean> list) {
        adapter.setLoadMoreData(list);
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
