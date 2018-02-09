package app.main.wangliwei.enablehands.presenter;


import java.util.List;

import app.main.wangliwei.enablehands.bean.NewsInfo;
import app.main.wangliwei.enablehands.model.NewsModel;

public class NewsPresenterImp extends INewsContract.INewsPresenter {
    private int id = 10;

    public NewsPresenterImp(INewsContract.INewsView view) {
        super(view);

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
    public void setNewsInfo(List<NewsInfo.T1348647909107Bean> list) {
        if(id <= 10) {
            mView.setNewsInfo(list);
        }else {
            mView.loadMore(list);
        }
        id += 10;
    }
}
