package app.main.wangliwei.baselib.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

/**
 * Created by wlw on 2018/3/19.
 */

public final class TimerUtil {
    private static Handler uiHandler;
    private static TextView mTextView;
    public static void setMinuteTimer(TextView textView) {
        if(uiHandler == null)uiHandler = new Handler(Looper.getMainLooper());

        textView.setEnabled(false);
        uiHandler.post(getMinuteRunnable(textView,uiHandler));
    }

    public static Runnable getMinuteRunnable(final TextView textView,
                                             final Handler handler) {
        mTextView = textView;

        return new Runnable() {
            int second = 60;
            @Override
            public void run() {
                this.update();
                second--;
                if(second < 0) {
                    mTextView.setText("获取验证码");
                    mTextView.setEnabled(true);
                    return;
                }
                handler.postDelayed(this,1000);

            }
            void update() {
                if(mTextView != null)
                mTextView.setText(second+" s");
            }
        };
    }

    public static void detach() {
        if (null == mTextView)return;
        uiHandler.removeCallbacksAndMessages(null);
        if(uiHandler == null) {
            mTextView.setText("获取验证码");
            mTextView.setEnabled(true);
            mTextView = null;
        }
    }
}
