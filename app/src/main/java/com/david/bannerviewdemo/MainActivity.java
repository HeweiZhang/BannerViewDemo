package com.david.bannerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.david.bannerviewdemo.custom.BannerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BannerView bannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bannerView = (BannerView) findViewById(R.id.bannerView);

        List<String> urls = new ArrayList<>();
        urls.add("http://img.zcool.cn/sucaiori/733B8D1B-4140-8B0C-EF86-CC6C6793D072.jpg@700w_0e_1l.jpg");
        urls.add("http://img.zcool.cn/sucaiori/BB0E9E48-9B9B-AC2B-EEB5-198391F8CC1A.jpg@700w_0e_1l.jpg");
        urls.add("http://img.zcool.cn/sucaiori/FE11B30D-FF9B-5D1F-4278-02D9BC31AB9C.jpg@700w_0e_1l.jpg");

        bannerView.setData(urls);
        bannerView.setOnClickListener(new BannerView.BannerOnClickListener() {
            @Override
            public void onClickListener(int pos) {
                Toast.makeText(MainActivity.this, "" + pos, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        bannerView.startBannerScrollTask(2000);//开启滚动
    }

    @Override
    protected void onStop() {
        super.onStop();
        bannerView.stopBannerTask();
    }
}
