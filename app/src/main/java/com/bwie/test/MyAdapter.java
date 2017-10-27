package com.bwie.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import imageloader.bwie.com.imageloaderlibrary.UtilImage;

/**
 * 作者： 方冬冬
 * 时间： 2017/10/26 15:07
 * 功能：
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Bean.SongListBean> list;
    private OnItemListener onItemListener;

    public MyAdapter(Context context, List<Bean.SongListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof MyViewHolder){
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.tvname.setText(list.get(position).getAuthor()+" - "+list.get(position).getAlbum_title());
            myViewHolder.tvtitle.setText(list.get(position).getTitle());
            ImageLoader.getInstance().displayImage(list.get(position).getPic_big(),myViewHolder.img, UtilImage.getOptions());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView tvtitle;
        TextView tvname;
        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvtitle = itemView.findViewById(R.id.tvtitle);
            tvname = itemView.findViewById(R.id.tvname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemListener.OnListener();
                }
            });
        }
    }


    //定义接口
    public interface OnItemListener{
        public void OnListener();
    }

    //回调方法
    public void setOnItemListener(OnItemListener onItemListener){
        this.onItemListener = onItemListener;
    }

}
