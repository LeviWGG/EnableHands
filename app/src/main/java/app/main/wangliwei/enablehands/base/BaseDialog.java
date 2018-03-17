package app.main.wangliwei.enablehands.base;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by wangliwei on 2018/3/17.
 */

public class BaseDialog extends Dialog {
    public BaseDialog(Context context) {
        super(context);
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BaseDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
