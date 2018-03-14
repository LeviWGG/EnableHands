package app.main.wangliwei.enablehands.base;


public abstract class BasePresenterFg<M, V> {
    public M mModel;
    public V mView;

    public BasePresenterFg(V view) {
        this.mView = view;
    }

    /**
     * 绑定IModel和IView的引用
     * @param modle
     * @param view
     */
    public void attachMV(M modle, V view) {
        this.mView = view;
        this.mModel = modle;
    }

    /**
     * 解绑IModel和IView
     */
    public void dettachMV() {
        this.mModel = null;
        this.mView = null;
    }
}
