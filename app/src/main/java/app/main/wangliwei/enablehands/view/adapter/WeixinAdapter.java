package app.main.wangliwei.enablehands.view.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.bean.Weixin;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WeixinAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int NORMAL_TYPE = 0;
    private Context context;
    private Fragment fragment;
    private List<Weixin.ResultBean.ListBean> list;
    private LayoutInflater layoutInflater;
    private ItemListener itemListener;

    public WeixinAdapter(Context context,Fragment fragment,List<Weixin.ResultBean.ListBean> list) {
        this.context = context;
        this.fragment = fragment;
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == NORMAL_TYPE) {
            view = layoutInflater.inflate(R.layout.item_picture,parent,false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemListener.onClick(view);
                }
            });
            WeixinAdapter.NormalViewHolder viewHolder = new WeixinAdapter.NormalViewHolder(view);
            return viewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof WeixinAdapter.NormalViewHolder) {
            setHeaderType((WeixinAdapter.NormalViewHolder) holder,position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.view_picture)
        ImageView mPicture;

        @BindView(R.id.text_title)
        TextView mTitle;

        @BindView(R.id.text_content)
        TextView mContent;

        @BindView(R.id.text_source)
        TextView mSource;

        @BindView(R.id.text_time)
        TextView mTime;

        View view;

        public NormalViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            ButterKnife.bind(this,itemView);
        }
    }

    private void setHeaderType(final WeixinAdapter.NormalViewHolder viewHolder, int pos) {
        Weixin.ResultBean.ListBean listBean = list.get(pos);
        Glide.with(fragment).load(listBean.getFirstImg()).into(viewHolder.mPicture);
        viewHolder.mTitle.setText(listBean.getTitle());
        viewHolder.mSource.setText(listBean.getSource());
        viewHolder.mTime.setText(listBean.getId().substring(7,15));
        viewHolder.view.setTag(listBean.getUrl());
//        viewHolder.mContent.setText(picture.getContent());
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public interface ItemListener {
        void onClick(View view);
    }
}
