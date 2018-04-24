package app.main.wangliwei.enablehands.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lzy.okgo.convert.Converter;

import java.lang.reflect.Type;

import app.main.wangliwei.enablehands.bean.HttpResult;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class BaseConvert<T> implements Converter<HttpResult<T>> {

    private Type mType;

    public BaseConvert(Type type) {
        mType = type;
    }

    @Override
    public HttpResult<T> convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) return null;
        String result = body.string();
        Gson gson = new GsonBuilder().registerTypeAdapter(Integer.class,new IntegerDefault0Adapter())
                .registerTypeAdapter(int.class,new IntegerDefault0Adapter())
                .registerTypeAdapter(Double.class,new DoubleDefaul0Adapter())
                .registerTypeAdapter(Long.class,new LongDefaul0Adapter()).create();
        return gson.fromJson(result, mType);
    }
}