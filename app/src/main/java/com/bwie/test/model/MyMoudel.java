package com.bwie.test.model;

import com.bwie.test.Bean;
import com.bwie.test.utils.GsonObjectCallback;
import com.bwie.test.utils.OkHttp3Utils;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;

/**
 * 作者： 方冬冬
 * 时间： 2017/10/26 14:48
 * 功能：
 */

public class MyMoudel {

    OnDataClieckListener onDataClieckListener;

    //请求数据
    public void getData(String url, final OnDataClieckListener onDataClieckListener){
        OkHttp3Utils.getInstance()
                .doGet(url, new GsonObjectCallback<Bean>() {
                    @Override
                    public void onUi(Bean bean) {
                        List<Bean.SongListBean> list = bean.getSong_list();
                        onDataClieckListener.onClick(list);
                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
    }

    //定义接口
    public interface OnDataClieckListener{
        public void onClick(List<Bean.SongListBean> list);
    }




}
