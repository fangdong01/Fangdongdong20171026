package com.bwie.test.presenter;

import com.bwie.test.Bean;
import com.bwie.test.model.MyMoudel;
import com.bwie.test.view.MyView;

import java.util.List;

/**
 * 作者： 方冬冬
 * 时间： 2017/10/26 14:55
 * 功能：
 */

public class MyPresenter {

    private MyView myView;
    private MyMoudel myMoudel;

    public MyPresenter(MyView myView) {
        this.myView = myView;
        this.myMoudel = new MyMoudel();
    }


    //关联
    public void show(String url){
        myMoudel.getData(url, new MyMoudel.OnDataClieckListener() {
            @Override
            public void onClick(List<Bean.SongListBean> list) {
                myView.success(list);
            }
        });
    }



}
