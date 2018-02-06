package app.main.wangliwei.enablehands.presenter;


import java.util.List;

import app.main.wangliwei.enablehands.base.BasePresenterFg;
import app.main.wangliwei.enablehands.bean.NewsInfo;
import io.reactivex.Observable;

public interface INewsContract {
    abstract class INewsPresenter extends BasePresenterFg<INewsModel,INewsView> {
        public INewsPresenter(INewsView view) {
            super(view);
        }

        public abstract void getNewsInfo();
        public abstract void setNewsInfo(List<NewsInfo.T1348647909107Bean> list);
    }

    interface INewsView {
        void setNewsInfo(List<NewsInfo.T1348647909107Bean> list);
    }

    interface INewsModel {
        void getNewsInfo(INewsPresenter iNewsPresenter);
    }
}
