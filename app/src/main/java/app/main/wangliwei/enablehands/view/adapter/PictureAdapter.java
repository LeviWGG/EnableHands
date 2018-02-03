package app.main.wangliwei.enablehands.view.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.bean.Picture;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PictureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int NORMAL_TYPE = 0;
    private Context context;
    private Fragment fragment;
    private List<Picture> list;
    private LayoutInflater layoutInflater;

    public PictureAdapter(Context context,Fragment fragment,List<Picture> list) {
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
            NormalViewHolder viewHolder = new NormalViewHolder(view);
            return viewHolder;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof NormalViewHolder) {
            setHeaderType((NormalViewHolder) holder,position);
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

        public NormalViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }

    private void setHeaderType(final NormalViewHolder viewHolder, int pos) {
        Picture picture = list.get(pos);
        Glide.with(fragment).load(picture.getPicture()).into(viewHolder.mPicture);
        viewHolder.mTitle.setText(picture.getTitle());
//        viewHolder.mContent.setText(picture.getContent());
    }
}
