package com.bwie.test;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import imageloader.bwie.com.imageloaderlibrary.UtilImage;

/**
 * 作者： 方冬冬
 * 时间： 2017/10/26 14:50
 * 功能：
 */

public class MyApp extends Application {

    public static MyApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        ImageLoaderConfiguration cofig = UtilImage.getConfiguration(this);
        ImageLoader.getInstance().init(cofig);
    }

    public static MyApp getInstance(){
        return mInstance;
    }


}
