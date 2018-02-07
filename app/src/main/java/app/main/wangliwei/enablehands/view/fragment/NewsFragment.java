package app.main.wangliwei.enablehands.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseFragment;
import app.main.wangliwei.enablehands.bean.NewsInfo;
import app.main.wangliwei.enablehands.presenter.INewsContract;
import app.main.wangliwei.enablehands.presenter.NewsPresenterImp;
import app.main.wangliwei.enablehands.view.WebDetailActivity;
import app.main.wangliwei.enablehands.view.adapter.NewsAdapter;
import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment implements INewsContract.INewsView {
    private View view;
    private INewsContract.INewsPresenter iNewsPresenter;

    @BindView(R.id.recycle_news)
    RecyclerView mRecyclerView;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = super.onCreateView(inflater,container,savedInstanceState);

        iNewsPresenter = new NewsPresenterImp(this);
        initView();

        return view;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    private void initView() {
        iNewsPresenter.getNewsInfo();
    }

    @Override
    public void setNewsInfo(List<NewsInfo.T1348647909107Bean> list) {
        NewsAdapter adapter = new NewsAdapter(this,list);
        adapter.setItemListener(new NewsAdapter.ItemListener() {
            @Override
            public void setOnClick(View view) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(((String)view.getTag()).equals("")) {
                            Log.d("item","is null");
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
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(adapter);
    }
}
