package app.main.wangliwei.enablehands.http;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import app.main.wangliwei.enablehands.app.MyApplication;
import app.main.wangliwei.enablehands.http.interceptor.CacheInterceptor;
import app.main.wangliwei.enablehands.http.interceptor.HttpLogInterceptor;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {
    private int DEFAULT_TIMEOUT = 8;


    public Retrofit create(String url) {
        return new Retrofit.Builder().baseUrl(url)
                .client(getOkhttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public OkHttpClient getOkhttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        File cachefile = new File(MyApplication.getMyContext().getExternalCacheDir(),"");
        Cache cache = new Cache(cachefile,1024*1024*30);
        builder.cache(cache);

        HttpLogInterceptor httpLogInterceptor = new HttpLogInterceptor();
        builder.addInterceptor(httpLogInterceptor);

        CacheInterceptor cacheInterceptor = new CacheInterceptor();
        builder.addInterceptor(cacheInterceptor);

        builder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS);
        builder.connectTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS);

        return builder.build();
    }
}
