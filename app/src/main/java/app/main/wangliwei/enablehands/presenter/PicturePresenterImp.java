package app.main.wangliwei.enablehands.presenter;


import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import app.main.wangliwei.enablehands.bean.ScrollEvent;
import app.main.wangliwei.enablehands.bean.Weixin;
import app.main.wangliwei.enablehands.http.ServiceFactory;
import app.main.wangliwei.enablehands.http.WeixinService;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class PicturePresenterImp extends IPictureContract.IPicturePresenter {
    private final static String BASE_URL = "http://v.juhe.cn/";
    private final static String KEY = "d99d7aa8e1709c2f115553b7c3b075eb";
    private int page = 1;

    public PicturePresenterImp(IPictureContract.IPictureView view) {
        super(view);
        //EventBus.getDefault().register(this);
    }

    @Override
    public void scrollToTop() {
        mView.scrollToTop();
    }

    @Override
    public void getWeixinNews() {
        Retrofit retrofit = new ServiceFactory().create(BASE_URL);
        WeixinService weixinService = retrofit.create(WeixinService.class);

        Observable<Weixin> observable = weixinService.getWeixinNews(page,10,"json",KEY);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<Weixin, ObservableSource<List<Weixin.ResultBean.ListBean>>>() {
                    @Override
                    public ObservableSource<List<Weixin.ResultBean.ListBean>> apply(Weixin weixin) throws Exception {
                        return Observable.just(weixin.getResult().getList());
                    }
                }).filter(new Predicate<List<Weixin.ResultBean.ListBean>>() {
            @Override
            public boolean test(List<Weixin.ResultBean.ListBean> listBeans) throws Exception {
                if(listBeans.isEmpty()) {
                    return false;
                }
                return true;
            }
        }).subscribe(new Consumer<List<Weixin.ResultBean.ListBean>>() {
            @Override
            public void accept(List<Weixin.ResultBean.ListBean> listBeans) throws Exception {
                if(page == 1) {
                    mView.setWeixinNews(listBeans);
                }else {
                    mView.loadMore(listBeans);
                }
                page++;
            }
        });
    }

    @Override
    public void onDestroy() {
//        if(EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().unregister(this);
//        }
    }

    @Subscribe
    public void fbtnEvent(ScrollEvent scrollEvent) {
        scrollToTop();
    }
}
