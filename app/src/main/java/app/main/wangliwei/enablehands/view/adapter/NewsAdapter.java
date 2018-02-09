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
import app.main.wangliwei.enablehands.bean.NewsInfo;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int NORMAL = 0;

    private List<NewsInfo.T1348647909107Bean> mEntertainments;
    private LayoutInflater layoutInflater;
    private Fragment fragment;
    private Context context;
    private ItemListener itemListener;

    public NewsAdapter(Fragment fragment,List<NewsInfo.T1348647909107Bean> list) {
        this.mEntertainments = list;
        this.fragment = fragment;
        this.context = fragment.getActivity();
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        return NORMAL;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType == NORMAL) {
            view = layoutInflater.inflate(R.layout.item_news_normal,parent,false);
            //view.setOnClickListener(onClickListener);
            itemListener.setOnClick(view);
            NormalViewHolder viewHolder = new NormalViewHolder(view);
            return viewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof NormalViewHolder) {
            setNormalType((NormalViewHolder)holder,position);
        }
    }

    @Override
    public int getItemCount() {
        return mEntertainments.size();
    }

    public static class NormalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_title)
        TextView title;

        @BindView(R.id.text_content)
        TextView content;

        @BindView(R.id.view_picture)
        ImageView imageView;

        View view;

        public NormalViewHolder(View itemView) {
            super(itemView);

            view = itemView;
            ButterKnife.bind(this,itemView);
        }
    }

    private void setNormalType(NormalViewHolder holder,int pos) {
        NewsInfo.T1348647909107Bean newsInfo = mEntertainments.get(pos);
        holder.title.setText(newsInfo.getTitle());
        holder.content.setText(newsInfo.getDigest());
        Log.d("adapter","url: "+newsInfo.getUrl());
        holder.view.setTag(newsInfo.getUrl());
        Glide.with(fragment).load(newsInfo.getImgsrc()).into(holder.imageView);
    }

    public interface ItemListener {
        void setOnClick(View view);
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setLoadMoreDatas(List<NewsInfo.T1348647909107Bean> list) {
        mEntertainments.addAll(list);
        notifyDataSetChanged();
    }

}
