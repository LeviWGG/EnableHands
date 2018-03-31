package app.main.wangliwei.enablehands.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import app.main.wangliwei.baselib.utils.BaseUtils;
import app.main.wangliwei.baselib.utils.ViewUtil;
import app.main.wangliwei.enablehands.R;

/**
 * Created by wlw on 2018/3/31.
 */

public class StateToast {
    public static void showShort(String message) {
        show(message, Toast.LENGTH_SHORT);
    }

    public static void showLong(String message) {
        show(message, Toast.LENGTH_LONG);
    }

    public static void showShort(int id) {
        show(ViewUtil.getResourceString(id),Toast.LENGTH_SHORT);
    }

    public static void showLong(int id) {
        show(ViewUtil.getResourceString(id),Toast.LENGTH_LONG);
    }

    private static void show(String massage, int show_length) {
        Context context = BaseUtils.getApp();
        //使用布局加载器，将编写的toast_layout布局加载进来
        View view = LayoutInflater.from(context).inflate(R.layout.toast_state, null);
        //获取TextView
        TextView title = view.findViewById(R.id.text_content);
        //设置显示的内容
        title.setText(massage);
        Toast toast = new Toast(context);
        //设置Toast要显示的位置，居中，X轴偏移0个单位，Y轴偏移0个单位，
        toast.setGravity(Gravity.CENTER, 0, 0);
        //设置显示时间
        toast.setDuration(show_length);
        toast.setView(view);
        toast.show();
    }
}
