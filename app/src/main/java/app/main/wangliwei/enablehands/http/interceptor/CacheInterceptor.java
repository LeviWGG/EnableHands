package app.main.wangliwei.enablehands.http.interceptor;


import java.io.IOException;

import app.main.wangliwei.enablehands.app.MyApplication;
import app.main.wangliwei.enablehands.utils.NetworkUtil;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //网络不可用
        if(!NetworkUtil.isNetworkAvailable(MyApplication.getMyContext())) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .url(chain.request().url())
                    .build();
        }

        if(NetworkUtil.isNetworkAvailable(MyApplication.getMyContext())) {
            //有网络时给相应头加上：缓存超时为0小时
            int maxAge = 0;
            request = request.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control","public, max-age="+maxAge)
                    .build();
        }else {
            //无网络时，在相应头加上：设置缓存超时为4周
            int maxStale = 60*60*24*28;
            request = request.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control","public, only-if-cached, max-stale="+maxStale)
                    .build();
        }

        return chain.proceed(request);
    }
}
