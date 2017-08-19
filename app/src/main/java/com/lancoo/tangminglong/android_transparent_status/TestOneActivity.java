package com.lancoo.tangminglong.android_transparent_status;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

/**
 * Created by tangminglong on 17/8/19.
 * 软键盘的处理主要放在该类
 * AndroidBug5497Workaround是我基于AndroidBug5497Workaround2[https://github.com/madebycm/AndroidBug5497Workaround]修改的
 */

public class TestOneActivity extends AppCompatActivity{

    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_one);
       AndroidBug5497Workaround.assistActivity(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            mToolbar.setPadding(mToolbar.getPaddingLeft(),getStatusBarHeight(this),
                    mToolbar.getPaddingRight(),mToolbar.getPaddingBottom());
        }
        mToolbar.setTitle("测试一");
        setSupportActionBar(mToolbar);
    }


    //通过反射获取状态栏高度，默认25dp
    private static int getStatusBarHeight(Context context) {
        int statusBarHeight = dip2px(context, 25);
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight;
    }

    //根据手机的分辨率从 dp 的单位 转成为 px(像素)
    private static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
