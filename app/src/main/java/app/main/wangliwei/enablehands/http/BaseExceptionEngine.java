package app.main.wangliwei.enablehands.http;

import android.util.Log;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import app.main.wangliwei.enablehands.bean.HttpResult;
import retrofit2.HttpException;

/**
 * Created by wlw on 2018/5/3.
 */

public class BaseExceptionEngine {
    public final static int HTTP_STATUS_NET_ERROR = -10000;
    public final static int HTTP_STATUS_PARSE_FAILED = -10001;
    public final static int HTTP_STATUS_DEFAULT_ERROR = -10002;

    public static HttpResult handleException(Throwable throwable) {
        Log.d("exception","Exception error : " + throwable.getClass());
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
        return httpResult;
    }
}
