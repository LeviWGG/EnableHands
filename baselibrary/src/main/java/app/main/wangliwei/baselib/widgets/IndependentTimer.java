package app.main.wangliwei.baselib.widgets;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

/**
 * Created by wlw on 2018/3/19.
 */

public class IndependentTimer {
    private Handler uiHandler;
    private TextView mTextView;
    public  void setMinuteTimer(TextView textView) {
        if(uiHandler == null)uiHandler = new Handler(Looper.getMainLooper());

        detach();
        textView.setEnabled(false);
        uiHandler.post(getMinuteRunnable(textView,uiHandler));
    }

    public Runnable getMinuteRunnable(final TextView textView,
                                             final Handler handler) {
        mTextView = textView;

        return new Runnable() {
            int second = 60;
            @Override
            public void run() {
                this.update();
                second--;
                if(second < 0) {
                    mTextView.setText("重新获取");
                    mTextView.setEnabled(true);
                    mTextView = null;
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

    public void detach() {
        if (uiHandler == null)return;
        uiHandler.removeCallbacksAndMessages(null);
        if (null != mTextView) {
            mTextView.setText("重新发送");
            mTextView.setEnabled(true);
            mTextView = null;
        }
    }
}
