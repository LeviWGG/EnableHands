package app.main.wangliwei.baselib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.List;

import app.main.wangliwei.baselib.R;

/**
 * Created by wlw on 2018/3/20.
 */

public class ItemViewFlipper extends ViewFlipper {
    private Context context;
    private onItemOnClickListener onItemOnClickListener;

    public ItemViewFlipper(Context context) {
        super(context);
        this.context = context;
        setDefaultAnim();
    }

    public ItemViewFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setDefaultAnim();
    }

    /**
     * 按序列加入view到Flipper中
     * @param viewList View
     */
    public void addViewList(List<View> viewList) {
        removeAllViews();
        for(View child : viewList) {
            addView(child);
        }
        setChildViewClick();
    }

    /**
     * 由字符数组生成对应TextView直接加入Flipper中
     * 可对默认布局修改达到需要效果
     * @param stringList TextView内容
     */
    public void addTextViewList(List<String> stringList) {
        removeAllViews();
        for(String string : stringList) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_text_view,null);
            ((TextView)view.findViewById(R.id.text_item_content)).setText(string);
            addView(view);
        }
        setChildViewClick();
    }

    private void setChildViewClick() {
        if(getChildCount() == 0)return;
        for(int i=0;i<getChildCount();i++) {
            final int pos = i;
            getChildAt(pos).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemOnClickListener.onItemClick(pos,view);
                }
            });
        }
    }

    private void setDefaultAnim() {
        setInAnimation(context,R.anim.push_up_in);
        setOutAnimation(context,R.anim.push_up_out);
    }

    public interface onItemOnClickListener {
        void onItemClick(int pos, View view);
    }

    public void setOnItemOnClickListener(ItemViewFlipper.onItemOnClickListener onItemOnClickListener) {
        this.onItemOnClickListener = onItemOnClickListener;
    }
}
