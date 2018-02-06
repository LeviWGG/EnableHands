package app.main.wangliwei.enablehands.http;


import app.main.wangliwei.enablehands.bean.NewsInfo;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface NewsService {
    public final static String BASE_URL = "http://c.m.163.com/";

    @Headers("User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)")
    @GET("nc/article/headline/T1348647909107/{id}-10.html")
    Observable<NewsInfo> getNewsInfo(@Path("id")int id);
}
