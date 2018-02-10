package app.main.wangliwei.enablehands.presenter;


import android.os.Handler;
import android.os.Looper;

import java.util.List;

import app.main.wangliwei.enablehands.bean.NewsInfo;
import app.main.wangliwei.enablehands.model.NewsModel;

public class NewsPresenterImp extends INewsContract.INewsPresenter {
    private int id = 10;
    private Handler uiHandler;

    public NewsPresenterImp(INewsContract.INewsView view) {
        super(view);

        uiHandler = new Handler(Looper.getMainLooper());
        mModel = new NewsModel();
    }

    @Override
    public void getNewsInfo() {
//        Observable<List<NewsInfo.T1348647909107Bean>> observable = mModel.getNewsInfo();
//        observable.subscribe(new Consumer<List<NewsInfo.T1348647909107Bean>>() {
//            @Override
//            public void accept(List<NewsInfo.T1348647909107Bean> t1348647909107Beans) throws Exception {
//                mView.setNewsInfo(t1348647909107Beans);
//            }
//        });
        mModel.getNewsInfo(this,id);
    }

    @Override
    public void setNewsInfo(final List<NewsInfo.T1348647909107Bean> list) {
        if(id <= 10) {
            mView.setNewsInfo(list);
        }else {
            uiHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mView.loadMore(list);
                }
            },2000);
        }
        id += 10;
    }
}
