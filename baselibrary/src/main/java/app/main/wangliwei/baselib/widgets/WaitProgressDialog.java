package app.main.wangliwei.baselib.widgets;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by wangliwei on 2018/3/18.
 */

public class WaitProgressDialog extends ProgressDialog {
    public WaitProgressDialog(Context context) {
        this(context,0);
    }

    public WaitProgressDialog(Context context, int theme) {
        super(context, theme);
    }
}
