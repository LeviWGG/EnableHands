package app.main.wangliwei.enablehands.model;

import android.util.Log;

import java.util.List;

import app.main.wangliwei.enablehands.bean.NewsInfo;
import app.main.wangliwei.enablehands.http.NewsService;
import app.main.wangliwei.enablehands.http.ServiceFactory;
import app.main.wangliwei.enablehands.presenter.INewsContract;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class NewsModel implements INewsContract.INewsModel {



    @Override
    public void getNewsInfo(final INewsContract.INewsPresenter iNewsPresenter,int id) {
        Retrofit retrofit = new ServiceFactory().create(NewsService.BASE_URL);
        NewsService newsService = retrofit.create(NewsService.class);

        Observable<NewsInfo> observable = newsService.getNewsInfo(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<NewsInfo, ObservableSource<List<NewsInfo.T1348647909107Bean>>>() {
                    @Override
                    public ObservableSource<List<NewsInfo.T1348647909107Bean>> apply(NewsInfo newsInfo) throws Exception {
                        return Observable.just(newsInfo.getT1348647909107());
                    }
                }).filter(new Predicate<List<NewsInfo.T1348647909107Bean>>() {
            @Override
            public boolean test(List<NewsInfo.T1348647909107Bean> t1348647909107Beans) throws Exception {
                if(t1348647909107Beans.isEmpty()) {
                    return false;
                }
                return true;
            }
        }).subscribe(new Consumer<List<NewsInfo.T1348647909107Bean>>() {
            @Override
            public void accept(List<NewsInfo.T1348647909107Bean> t1348647909107Beans) throws Exception {
                //遍历新闻信息，去掉没有URL的子项
                for(int i=0;i<t1348647909107Beans.size();i++) {
                    if(t1348647909107Beans.get(i).getUrl() == null) {
                        t1348647909107Beans.remove(i);
                    }
                }
                iNewsPresenter.setNewsInfo(t1348647909107Beans);
            }
        });

//        return (Observable<T>) observable;
    }
}
