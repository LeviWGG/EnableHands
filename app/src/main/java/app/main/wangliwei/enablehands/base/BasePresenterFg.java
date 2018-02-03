package app.main.wangliwei.enablehands.base;


public abstract class BasePresenterFg<M, V> {
    public M mModel;
    public V mView;

    public BasePresenterFg(V view) {
        this.mView = view;
    }
}
