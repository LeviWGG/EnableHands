package app.main.wangliwei.enablehands.http;

import android.util.Log;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import app.main.wangliwei.enablehands.bean.HttpResult;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseObserver<T> implements Observer<HttpResult<T>> {

    public final static int HTTP_STATUS_NET_ERROR = -10000;
    public final static int HTTP_STATUS_PARSE_FAILED = -10001;
    public final static int HTTP_STATUS_DEFAULT_ERROR = -10002;

    @Override
    public void onSubscribe(Disposable d) {
        onBitkerSubscribe(d);
    }

    @Override
    public void onNext(HttpResult<T> t) {
        if (200 == t.getStatus()) {
            onBitkerSuccess(t);
        } else {
            if (302 == t.getStatus()) {

            }
            onBitkerError(t);
        }
    }

    @Override
    public void onError(Throwable throwable) {
        HttpResult httpResult = new HttpResult();
        if (throwable instanceof HttpException || throwable instanceof ConnectException || throwable instanceof SocketTimeoutException) {//均视为网络错误
            httpResult.setStatus(HTTP_STATUS_NET_ERROR);
            httpResult.setMsg("网络连接失败，请稍后再试");
        } else if (throwable instanceof JsonParseException || throwable instanceof JSONException || throwable instanceof ParseException) {
            httpResult.setStatus(HTTP_STATUS_PARSE_FAILED);
            httpResult.setMsg("加载失败，请稍后再试");
        } else {
            httpResult.setStatus(HTTP_STATUS_DEFAULT_ERROR);
            httpResult.setMsg("系统繁忙，请稍后再试");
        }
        Log.e("http error",""+throwable.getClass());
        onBitkerError(httpResult);
    }

    @Override
    public void onComplete() {

    }

    public abstract void onBitkerSubscribe(Disposable d);

    public abstract void onBitkerSuccess(HttpResult<T> t);

    public abstract void onBitkerError(HttpResult httpResult);
}
