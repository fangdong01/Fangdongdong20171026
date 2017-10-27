package com.bwie.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView mry;
    private CheckBox quan;
    private TextView zongji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //找控件
        mry = (RecyclerView) findViewById(R.id.mry);
        quan = (CheckBox) findViewById(R.id.duo);
        zongji = (TextView) findViewById(R.id.zongji);
        mry.setLayoutManager(new LinearLayoutManager(this));

        //实例化数据
        final ArrayList<ShopBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ShopBean(true,"商品"+i,50,1));
        }

        final MyRyAdapter adapter = new MyRyAdapter(this,list);
        mry.setAdapter(adapter);
        //默认全选
        jisuan(list);
        quan.setChecked(true);

        //接口回跳
        adapter.setOnReferListener(new MyRyAdapter.OnReferListener() {
            @Override
            public void onRefer(boolean flag, ArrayList<ShopBean> lists) {
                quan.setChecked(flag);
                jisuan(lists);
            }
        });

        //全选的点击事件
        quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = quan.isChecked();
                adapter.quanxuan(checked);
            }
        });

    }


    //计算总价
    public void jisuan(ArrayList<ShopBean> lists){
        int count = 0;
        int zprice = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i).isFlag()){
                count += lists.get(i).getNum();
                zprice += lists.get(i).getNum() * lists.get(i).getPrice();
            }
        }
        zongji.setText("共计"+count+"件，总价"+zprice+"元");
    }


}
