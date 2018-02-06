package app.main.wangliwei.enablehands.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by wangliwei on 2018/2/6.
 */

public class NewsList implements Serializable {
    @SerializedName("T1348647909107")
    ArrayList<NewsInfo> newsList;

    public ArrayList<NewsInfo> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<NewsInfo> newsList) {
        this.newsList = newsList;
    }
}
