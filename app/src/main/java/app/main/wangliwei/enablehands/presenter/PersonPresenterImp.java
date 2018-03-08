package app.main.wangliwei.enablehands.presenter;


import android.os.Handler;
import android.os.Looper;

import com.bumptech.glide.Glide;

public class PersonPresenterImp extends IPersonContract.IPersonPresenter {
    private Handler uiHandler;

    public PersonPresenterImp(IPersonContract.IPersonView view) {
        super(view);

        uiHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void clearMemory() {
        uiHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Glide.get(mView.getContext()).clearMemory();
                mView.showToast("clear success");
            }
        },0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(mView.getContext()).clearDiskCache();
            }
        }).start();
    }
}
