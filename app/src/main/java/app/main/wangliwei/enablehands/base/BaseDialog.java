package app.main.wangliwei.enablehands.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangliwei on 2018/3/17.
 */

public abstract class BaseDialog extends Dialog {
    private Context mContext;
    private Unbinder unbinder;

    public BaseDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.mContext = context;
    }

    protected BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(mContext,getLayoutId(),null);
        setContentView(view);

        unbinder = ButterKnife.bind(this,view);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unbinder.unbind();
    }

    abstract int getLayoutId();
}
