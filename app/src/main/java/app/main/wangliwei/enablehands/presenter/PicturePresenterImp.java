package app.main.wangliwei.enablehands.presenter;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import app.main.wangliwei.enablehands.bean.ScrollEvent;

public class PicturePresenterImp extends IPictureContract.IPicturePresenter {

    public PicturePresenterImp(IPictureContract.IPictureView view) {
        super(view);
        EventBus.getDefault().register(this);
    }

    @Override
    public void scrollToTop() {
        mView.scrollToTop();
    }

    @Subscribe
    public void fbtnEvent(ScrollEvent scrollEvent) {
        scrollToTop();
    }
}
