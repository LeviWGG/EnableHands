package app.main.wangliwei.baselib.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import app.main.wangliwei.baselib.R;

/**
 * Created by wlw on 2018/3/24.
 */

public class PopUpWindowAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public PopUpWindowAdapter(int layoutResId) {
        super(layoutResId, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.text_content,item);
        helper.addOnClickListener(R.id.text_content);
    }
}
