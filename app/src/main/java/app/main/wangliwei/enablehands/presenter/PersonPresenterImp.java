package app.main.wangliwei.enablehands.presenter;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.bumptech.glide.Glide;

public class PersonPresenterImp extends IPersonContract.IPersonPresenter {
    private static final int UI_TOAST = 1;
    private static final int CLEAR_MEMORY = 2;
    private Handler uiHandler;

    public PersonPresenterImp(IPersonContract.IPersonView view) {
        super(view);

        uiHandler = new UiHandler(Looper.getMainLooper());
    }

    public class UiHandler extends Handler{
        UiHandler(Looper looper){
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case UI_TOAST :
                    mView.showToast("clear success");
                    break;
                case CLEAR_MEMORY :
                    Glide.get(mView.getContext()).clearMemory();
                    break;
            }
        }
    }

    @Override
    public void clearMemory() {
        uiHandler.sendEmptyMessage(CLEAR_MEMORY);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(mView.getContext()).clearDiskCache();
                uiHandler.sendEmptyMessage(UI_TOAST);
            }
        }).start();
    }
}
