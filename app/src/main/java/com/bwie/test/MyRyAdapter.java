package com.bwie.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * 作者： 方冬冬
 * 时间： 2017/10/26 15:49
 * 功能：
 */

public class MyRyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<ShopBean> list;
    private OnReferListener onReferListener;

    public MyRyAdapter(Context context, ArrayList<ShopBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.shop,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof MyViewHolder){
            MyViewHolder myViewHolder = (MyViewHolder) holder;

            myViewHolder.cb.setChecked(list.get(position).isFlag());
            myViewHolder.name.setText(list.get(position).getName());
            myViewHolder.danjia.setText("单价："+list.get(position).getPrice()+"￥");
            myViewHolder.av.setTv(list.get(position).getNum()+"");
            myViewHolder.jisuan.setText("共计"+list.get(position).getNum()+"件，总价"+(list.get(position).getNum()*list.get(position).getPrice())+"元");



            //单选点击事件
            myViewHolder.cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list.get(position).setFlag(!list.get(position).isFlag());
                    boolean flag = true;
                    for (int i = 0; i < list.size(); i++) {
                        if (!list.get(i).isFlag()){
                            flag = false;
                        }
                    }
                    onReferListener.onRefer(flag,list);
                    notifyDataSetChanged();
                }
            });


            //删除点击事件
            myViewHolder.del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    list.remove(position);
                    boolean flag = true;
                    for (int i = 0; i < list.size(); i++) {
                        if (!list.get(i).isFlag()){
                            flag = false;
                            break;
                        }
                    }
                    onReferListener.onRefer(flag,list);
                    notifyDataSetChanged();
                }
            });



            //自定义点击事件
            myViewHolder.av.setOnAmountChangeListener(new AmountView.OnAmountChangeListener() {
                @Override
                public void onAmountChange(View view, int amount) {
                    list.get(position).setNum(amount);
                    boolean flag = true;
                    for (int i = 0; i < list.size(); i++) {
                        if (!list.get(i).isFlag()){
                            flag = false;
                            break;
                        }
                    }
                    onReferListener.onRefer(flag,list);
                    notifyDataSetChanged();
                }
            });


        }

    }


    //全选事件
    public void quanxuan(boolean isFlag){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setFlag(isFlag);
        }
        onReferListener.onRefer(isFlag,list);
        notifyDataSetChanged();
    }


    //定义接口
    public interface OnReferListener{
        public void onRefer(boolean flag,ArrayList<ShopBean> lists);
    }

    //接口回调方法
    public void setOnReferListener(OnReferListener onReferListener){
        this.onReferListener = onReferListener;
    }





    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        CheckBox cb;
        TextView name,danjia,jisuan,del;
        AmountView av;
        public MyViewHolder(View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.cb);
            name = itemView.findViewById(R.id.name);
            danjia = itemView.findViewById(R.id.danjia);
            jisuan = itemView.findViewById(R.id.jisuan);
            del = itemView.findViewById(R.id.del);
            av = itemView.findViewById(R.id.amount_view);
        }
    }

}
