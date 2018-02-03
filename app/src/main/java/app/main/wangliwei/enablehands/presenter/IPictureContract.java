package app.main.wangliwei.enablehands.presenter;


import app.main.wangliwei.enablehands.base.BasePresenterFg;

public interface IPictureContract {
    public abstract class IPicturePresenter extends BasePresenterFg<IPictureModel,IPictureView> {
        public IPicturePresenter(IPictureView view) {
            super(view);
        }

        public abstract void scrollToTop();
    }

    public interface IPictureView {
        void scrollToTop();
    }

    public  interface IPictureModel {}
}
