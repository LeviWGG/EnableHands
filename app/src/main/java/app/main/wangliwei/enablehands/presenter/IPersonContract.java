package app.main.wangliwei.enablehands.presenter;


import android.content.Context;

import app.main.wangliwei.enablehands.base.BasePresenterFg;

public interface IPersonContract {
    abstract class IPersonPresenter extends BasePresenterFg<IPersonModel,IPersonView> {
        public IPersonPresenter (IPersonView view) {super(view);}

        public abstract void clearMemory();
    }

    interface IPersonView {
        void showToast(String text);
        Context getContext();
    }

    interface IPersonModel {}
}
