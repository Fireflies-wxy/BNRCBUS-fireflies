package com.bnrc.bnrcbus.activity.base;

import android.support.annotation.ColorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bnrc.bnrcbus.R;
import com.bnrc.bnrcbus.util.StatusBarUtil;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void changeStatusBarColor(@ColorRes int color){
        StatusBarUtil.setStatusBarColor(this,color);
    }
}
