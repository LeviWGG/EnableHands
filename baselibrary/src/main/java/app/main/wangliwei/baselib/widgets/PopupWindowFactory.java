package app.main.wangliwei.baselib.widgets;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.Arrays;
import java.util.List;

import app.main.wangliwei.baselib.R;
import app.main.wangliwei.baselib.adapter.PopUpWindowAdapter;

/**
 * Created by wlw on 2018/3/24.
 */


/**
 * 一个公用的PopUpWindow
 * 目前支持左右两种消息框
 */
public class PopupWindowFactory extends PopupWindow {
    public static int LEFT = 0;
    public static int RIGHT = 1;
    private View windowView;
    private Context context;
    private String[] items;
    private List<String> listItem;

    private ImageView imageUp;
    private RecyclerView recyclerView;
    private PopUpWindowAdapter popUpWindowAdapter;

    public PopupWindowFactory(Context context, int direction, String... items) {
        super(context);
        this.context = context;
        this.items = items;
        if(LEFT == direction) {
            windowView = LayoutInflater.from(context).inflate(R.layout.popup_window_left,null);
        }
        if(RIGHT == direction) {
            windowView = LayoutInflater.from(context).inflate(R.layout.popup_window_right,null);
        }
        recyclerView = windowView.findViewById(R.id.recycler_only);
        imageUp = windowView.findViewById(R.id.image_up);
        popUpWindowAdapter = new PopUpWindowAdapter(R.layout.item_assets_type);
        listItem = Arrays.asList(items);
    }

    public PopupWindowFactory(Context context,int direction,List<String> list) {
        super(context);
        this.context = context;
        if(LEFT == direction) {
            windowView = LayoutInflater.from(context).inflate(R.layout.popup_window_left,null);
        }
        if(RIGHT == direction) {
            windowView = LayoutInflater.from(context).inflate(R.layout.popup_window_right,null);
        }
        recyclerView = windowView.findViewById(R.id.recycler_only);
        imageUp = windowView.findViewById(R.id.image_up);
        popUpWindowAdapter = new PopUpWindowAdapter(R.layout.item_assets_type);
        listItem = list;
    }

    private void initView(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(context)
                .colorResId(R.color.Color_242B38)
                .size(1)
                .build());
        recyclerView.setAdapter(popUpWindowAdapter);
        popUpWindowAdapter.setNewData(listItem);
        setWidth(view.getWidth());
        setFocusable(true);
        setContentView(windowView);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override
    public void showAsDropDown(View anchor) {
        initView(anchor);
        super.showAsDropDown(anchor);
    }

    public PopUpWindowAdapter getPopUpWindowAdapter() {
        return popUpWindowAdapter;
    }
}
