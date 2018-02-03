package app.main.wangliwei.enablehands.presenter;


import java.util.List;

import app.main.wangliwei.enablehands.base.BasePresenterFg;
import app.main.wangliwei.enablehands.bean.Weixin;

public interface IPictureContract {
    abstract class IPicturePresenter extends BasePresenterFg<IPictureModel,IPictureView> {
        public IPicturePresenter(IPictureView view) {
            super(view);
        }

        public abstract void scrollToTop();

        public abstract void getWeixinNews();
    }

    interface IPictureView {
        void scrollToTop();
        void setWeixinNews(List<Weixin.ResultBean.ListBean> list);
    }

    interface IPictureModel {}
}
