package app.main.wangliwei.enablehands.http;

import app.main.wangliwei.enablehands.bean.HttpResult;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<HttpResult<T>> {

    @Override
    public void onSubscribe(Disposable d) {
        onBaseSubscribe(d);
    }

    @Override
    public void onNext(HttpResult<T> t) {
        if (200 == t.getStatus()) {
            try {
                onBaseSuccess(t);
            } catch (Exception e) {
                e.printStackTrace();
                onBaseError(BaseExceptionEngine.handleException(new Exception()));
            }
        } else {
            if (302 == t.getStatus()) {

            }
            onBaseError(t);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        onBaseError(BaseExceptionEngine.handleException(throwable));
    }

    @Override
    public void onComplete() {

    }

    public abstract void onBaseSubscribe(Disposable d);

    public abstract void onBaseSuccess(HttpResult<T> t);

    public abstract void onBaseError(HttpResult httpResult);
}
