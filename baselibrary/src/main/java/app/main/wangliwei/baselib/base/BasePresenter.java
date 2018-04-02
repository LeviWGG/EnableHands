package app.main.wangliwei.baselib.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by wlw on 2018/4/2.
 */

public abstract class BasePresenter<M,V> {
    public M mModel;
    public V mView;
    private CompositeDisposable mCompositeDisposable;

    /**
     * 在构造方法中赋值view
     *
     * @param view IView
     */
    public BasePresenter(V view) {
        this.mView = view;
        mCompositeDisposable = new CompositeDisposable();
    }


    public void addDisposable(Disposable d) {
        mCompositeDisposable.add(d);
    }

    /**
     * 绑定IModel和IView的引用
     *
     * @param modle IModel
     * @param view  IView
     */
    protected void attachMV(M modle, V view) {
        this.mView = view;
        this.mModel = modle;
        onStart();
    }

    /**
     * 解绑IModel和IView
     */
    protected void dettachMV() {
        if (null != mCompositeDisposable && mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.clear();
        }
        this.mModel = null;
        this.mView = null;
    }

    /**
     * 在绑定后进行数据或者界面的初始化
     */
    public abstract void onStart();
}
