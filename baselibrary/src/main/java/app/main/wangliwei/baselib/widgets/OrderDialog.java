package app.main.wangliwei.baselib.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

import app.main.wangliwei.baselib.R;
import app.main.wangliwei.baselib.base.BaseDialog;
import app.main.wangliwei.baselib.utils.ViewUtil;

/**
 * Created by wlw on 2018/3/22.
 */

public class OrderDialog extends BaseDialog {

    private OnItemOnClickListener onItemOnClickListener;

    TextView title;

    TextView content;

    TextView btnLeft;

    TextView btnRight;

    CheckBox checkBox;

    LinearLayout layoutTwoBtn;

    TextView btnOnly;

    LinearLayout dialogLayout;

    View viewLine1;
    View viewLine2;

    public OrderDialog(@NonNull Context context) {
        this(context, R.style.dialog);
    }

    public OrderDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected OrderDialog(@NonNull Context context, boolean cancelable, @Nullable DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    public void initView(View view) {
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = (int)(display.getWidth() * 0.8);
        getWindow().setAttributes(lp);
        title = view.findViewById(R.id.text_dialog_title);
        content = view.findViewById(R.id.text_dialog_content);
        btnLeft = view.findViewById(R.id.text_dialog_left);
        btnRight = view.findViewById(R.id.text_dialog_right);
        checkBox = view.findViewById(R.id.checkbox_dialog);
        layoutTwoBtn = view.findViewById(R.id.layout_button_two);
        btnOnly = view.findViewById(R.id.text_dialog_only_btn);
        dialogLayout = view.findViewById(R.id.dialog_layout);
        viewLine1 = view.findViewById(R.id.view_line1);
        viewLine2 = view.findViewById(R.id.view_line2);
        List<View> viewList = new ArrayList<>();
        viewList.add(title);
        viewList.add(content);
        viewList.add(btnLeft);
        viewList.add(btnRight);
        viewList.add(checkBox);
        viewList.add(layoutTwoBtn);
        viewList.add(btnOnly);
        for (View item : viewList) {
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemOnClickListener.onItemOnClick(view,OrderDialog.this);
                }
            });
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_order;
    }


    @IntDef({View.GONE,View.VISIBLE,View.INVISIBLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {}


    public OrderDialog setTitleCustom(String msg) {
        if (title.getVisibility() == View.GONE) {
            title.setVisibility(View.VISIBLE);
        }
        title.setText(msg);
        return this;
    }

    public OrderDialog setTitleCustom(int resId) {
        if (title.getVisibility() == View.GONE) {
            title.setVisibility(View.VISIBLE);
        }
        title.setText(resId);
        return this;
    }

    public OrderDialog setTitleCustom(String msg,int color) {
        if (title.getVisibility() == View.GONE) {
            title.setVisibility(View.VISIBLE);
        }
        title.setText(msg);
        title.setTextColor(ViewUtil.getResourceColor(color));
        return this;
    }

    public OrderDialog setTitleCustom(int resId,int color) {
        if (title.getVisibility() == View.GONE) {
            title.setVisibility(View.VISIBLE);
        }
        title.setText(resId);
        title.setTextColor(ViewUtil.getResourceColor(color));
        return this;
    }

    public OrderDialog setContent(String msg) {
        if(View.GONE == this.content.getVisibility()) {
            this.content.setVisibility(View.VISIBLE);
        }
        this.content.setText(msg);
        return this;
    }

    public OrderDialog setContent(int resId) {
        if(View.GONE == this.content.getVisibility()) {
            this.content.setVisibility(View.VISIBLE);
        }
        this.content.setText(resId);
        return this;
    }

    public OrderDialog setContent(int resId,float size) {
        if(View.GONE == this.content.getVisibility()) {
            this.content.setVisibility(View.VISIBLE);
        }
        this.content.setTextSize(size);
        this.content.setText(resId);
        return this;
    }

    public OrderDialog setContent(String msg,float size) {
        if(View.GONE == this.content.getVisibility()) {
            this.content.setVisibility(View.VISIBLE);
        }
        this.content.setTextSize(size);
        this.content.setText(msg);
        return this;
    }

    public OrderDialog setContentColor(int color) {
        content.setTextColor(ViewUtil.getResourceColor(color));
        return this;
    }

    public OrderDialog setLeft(String msg) {
        if (layoutTwoBtn.getVisibility() == View.GONE) {
            layoutTwoBtn.setVisibility(View.VISIBLE);
            btnOnly.setVisibility(View.GONE);
        }
        btnLeft.setText(msg);
        return this;
    }

    public OrderDialog setLeft(int resId) {
        if (layoutTwoBtn.getVisibility() == View.GONE) {
            layoutTwoBtn.setVisibility(View.VISIBLE);
            btnOnly.setVisibility(View.GONE);
        }
        btnLeft.setText(resId);
        return this;
    }

    public OrderDialog setLeft(int resId,int color) {
        if (layoutTwoBtn.getVisibility() == View.GONE) {
            layoutTwoBtn.setVisibility(View.VISIBLE);
            btnOnly.setVisibility(View.GONE);
        }
        btnLeft.setText(resId);
        btnLeft.setTextColor(ViewUtil.getResourceColor(color));
        return this;
    }

    public OrderDialog setLeft(String msg, int color) {
        if (layoutTwoBtn.getVisibility() == View.GONE) {
            layoutTwoBtn.setVisibility(View.VISIBLE);
            btnOnly.setVisibility(View.GONE);
        }
        btnLeft.setText(msg);
        btnLeft.setTextColor(ViewUtil.getResourceColor(color));
        return this;
    }

    public OrderDialog setRight(String msg) {
        if (layoutTwoBtn.getVisibility() == View.GONE) {
            layoutTwoBtn.setVisibility(View.VISIBLE);
            btnOnly.setVisibility(View.GONE);
        }
        btnRight.setText(msg);
        return this;
    }

    public OrderDialog setRight(int resId) {
        if (layoutTwoBtn.getVisibility() == View.GONE) {
            layoutTwoBtn.setVisibility(View.VISIBLE);
            btnOnly.setVisibility(View.GONE);
        }
        btnRight.setText(resId);
        return this;
    }

    public OrderDialog setRight(int resId,int color) {
        if (layoutTwoBtn.getVisibility() == View.GONE) {
            layoutTwoBtn.setVisibility(View.VISIBLE);
            btnOnly.setVisibility(View.GONE);
        }
        btnRight.setText(resId);
        btnRight.setTextColor(ViewUtil.getResourceColor(color));
        return this;
    }
    public OrderDialog setRight(String msg, int color) {
        if (layoutTwoBtn.getVisibility() == View.GONE) {
            layoutTwoBtn.setVisibility(View.VISIBLE);
            btnOnly.setVisibility(View.GONE);
        }
        btnRight.setText(msg);
        btnRight.setTextColor(ViewUtil.getResourceColor(color));
        return this;
    }

    public OrderDialog setCheckBox(String msg) {
        if (checkBox.getVisibility() == View.GONE) {
            checkBox.setVisibility(View.VISIBLE);
        }
        checkBox.setText(msg);
        return this;
    }

    public OrderDialog setCheckBox(int resId) {
        if (checkBox.getVisibility() == View.GONE) {
            checkBox.setVisibility(View.VISIBLE);
        }
        checkBox.setText(resId);
        return this;
    }

    public OrderDialog setOnlyBtn(String msg) {
        if (btnOnly.getVisibility() == View.GONE) {
            btnOnly.setVisibility(View.VISIBLE);
            layoutTwoBtn.setVisibility(View.GONE);
        }
        btnOnly.setText(msg);
        return this;
    }

    public OrderDialog setOnlyBtn(int resId) {
        if (btnOnly.getVisibility() == View.GONE) {
            btnOnly.setVisibility(View.VISIBLE);
            layoutTwoBtn.setVisibility(View.GONE);
        }
        btnOnly.setText(resId);
        return this;
    }

    public interface OnItemOnClickListener {
        void onItemOnClick(View view, OrderDialog orderDialog);
    }

    public void setOnItemOnClickListener(OnItemOnClickListener onItemOnClickListener) {
        this.onItemOnClickListener = onItemOnClickListener;
    }

    public OrderDialog setLineColor(int color) {
        viewLine1.setBackgroundColor(ViewUtil.getResourceColor(color));
        viewLine2.setBackgroundColor(ViewUtil.getResourceColor(color));
        return this;
    }

    public OrderDialog setBackgroundResource(int res) {
        dialogLayout.setBackgroundResource(res);
        return this;
    }
}
