package app.main.wangliwei.baselib.widgets;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import app.main.wangliwei.baselib.R;

/**
 * Created by wlw on 2018/4/16.
 */

public class PersonalPopupWindow extends PopupWindow {
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private LinearLayout llPopupRoot;
    private boolean isShowAniming;//show动画是否在执行中
    private boolean isHideAniming;//hide动画是否在执行中

    public PersonalPopupWindow(Context context) {
        super(null, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mContext = context;
        //设置点击空白处消失
        setTouchable(true);
        setOutsideTouchable(true);
        //setClippingEnabled(false);

        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int w = wm.getDefaultDisplay().getWidth();
        int h = wm.getDefaultDisplay().getHeight();
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.parseColor("#88000000"));//填充颜色
        setBackgroundDrawable(new BitmapDrawable(context.getResources(), bitmap));

        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        initView();
    }

    private void initView() {
        View rootView = LayoutInflater.from(mContext).inflate(R.layout.layout_popupwindow, null);
        setContentView(rootView);

        llPopupRoot = rootView.findViewById(R.id.ll_popup_root);
        TextView btnCarema = rootView.findViewById(R.id.btn_camera);
        TextView btnPhoto = rootView.findViewById(R.id.btn_photo);
        TextView btnCancel = rootView.findViewById(R.id.btn_cancel);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowing())
                    dismiss();
            }
        });

        btnCarema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null)
                    mOnItemClickListener.onCaremaClicked();
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null)
                    mOnItemClickListener.onPhotoClicked();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null)
                    mOnItemClickListener.onCancelClicked();
            }
        });
    }

    public void showAtLocation(View parent) {
        this.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        super.showAtLocation(parent, gravity, x, y);
        if (!isShowAniming) {
            isShowAniming = true;
            popupAnim(llPopupRoot, 0.0f, 1.0f, 500, true);
        }
    }

    @Override
    public void dismiss() {
        if (!isHideAniming) {
            isHideAniming = true;
            popupAnim(llPopupRoot, 1.0f, 0.0f, 500, false);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onCaremaClicked();

        void onPhotoClicked();

        void onCancelClicked();
    }

    /**
     * popupWindow属性动画
     *
     * @param view     执行属性动画的view
     * @param start    start值
     * @param end      end值
     * @param duration 动画持续时间
     * @param flag     true代表show，false代表hide
     */
    private void popupAnim(final View view, float start, final float end, int duration, final
    boolean flag) {
        ValueAnimator va = ValueAnimator.ofFloat(start, end).setDuration(duration);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                view.setPivotX(0);
                view.setPivotY(view.getMeasuredHeight());
                view.setTranslationY((1 - value) * view.getHeight());
            }
        });
        va.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                if (!flag) {
                    isHideAniming = false;
                    PersonalPopupWindow.super.dismiss();
                }else {
                    isShowAniming = false;
                }
            }
        });
        va.start();
    }
}
