package com.bwie.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.test.presenter.MyPresenter;
import com.bwie.test.view.MyView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyView {

    private RecyclerView ry;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        ry = (RecyclerView) findViewById(R.id.ry);
        ry.setLayoutManager(new LinearLayoutManager(this));
        //实例化MyPresenter
        MyPresenter myPresenter = new MyPresenter(this);
        //调用显示关联方法
        myPresenter.show("http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0");

    }

    //实现接口
    @Override
    public void success(List<Bean.SongListBean> list) {
        adapter = new MyAdapter(MainActivity.this,list);
        ry.setAdapter(adapter);

        //接口回调进行跳转
        adapter.setOnItemListener(new MyAdapter.OnItemListener() {
            @Override
            public void OnListener() {
                //跳转
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}
