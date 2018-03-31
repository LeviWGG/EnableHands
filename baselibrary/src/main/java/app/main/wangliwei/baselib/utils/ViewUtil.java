package app.main.wangliwei.baselib.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


public class ViewUtil {

    /**
     * 设置密码是否可见
     *
     * @param editText
     * @param passwordIsVisible
     */
    public static void setEtPasswordVisible(EditText editText, boolean passwordIsVisible) {
        if (passwordIsVisible) {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    /**
     * 获取color
     *
     * @param color
     * @return
     */
    public static int getResourceColor(@ColorRes final int color) {
        return ContextCompat.getColor(BaseUtils.getApp(), color);
    }

    /**
     * 获取String
     *
     * @param resId
     * @return
     */
    public static String getResourceString(@StringRes final int resId) {
        return BaseUtils.getApp().getResources().getString(resId);
    }

    /**
     * 文本复制
     *
     * @param content
     */
    public static void copy(String content, Context context) {
        // 得到剪贴板管理器
        ClipboardManager cmb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = ClipData.newPlainText("", content);
        if (cmb != null) {
            cmb.setPrimaryClip(clipData);
        }
    }

    /**
     * 设置文字的右边图片
     *
     * @param textView
     * @param redId
     */
    public static void setDrawableRight(TextView textView, @DrawableRes int redId) {
        Drawable drawable = BaseUtils.getApp().getResources().getDrawable(redId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, null, drawable, null);
    }

    /**
     * 设置文字的上方图片
     *
     * @param textView
     * @param redId
     */
    public static void setDrawableTop(TextView textView, @DrawableRes int redId) {
        Drawable drawable = BaseUtils.getApp().getResources().getDrawable(redId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
    }

    /**
     * 获得屏幕宽度
     *
     * @return
     */
    public static int getScreenHeight() {
        WindowManager wm = (WindowManager) BaseUtils.getApp().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        if (wm != null) {
            wm.getDefaultDisplay().getMetrics(outMetrics);
        } else {
            return 0;
        }
        return outMetrics.heightPixels;
    }

    /**
     * 获得屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) BaseUtils.getApp().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        if (wm != null) {
            wm.getDefaultDisplay().getMetrics(outMetrics);
        } else {
            return 0;
        }
        return outMetrics.widthPixels;
    }

    /**
     * 获得状态栏的高度
     *
     * @return
     */
    public static int getStatusHeight() {
        int statusHeight = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen.xml");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusHeight = BaseUtils.getApp().getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return statusHeight;
    }

}
