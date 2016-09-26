package com.david.bannerviewdemo;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2016/9/26.
 */
public class AppContext extends Application {

    /**
     * 能在app工程的任何地方通过AppContext.getInstance()来获得Application全局对象
     */
    private static AppContext instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initImageLoader();
    }

    /**
     * ImageLoader 初始化操作
     */
    private void initImageLoader() {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(instance)
                .writeDebugLogs()//打开log打印图片加载信息
                .build();
        ImageLoader.getInstance().init(configuration);
    }
}
