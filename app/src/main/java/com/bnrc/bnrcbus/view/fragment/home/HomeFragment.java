package com.bnrc.bnrcbus.view.fragment.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bnrc.bnrcbus.R;
import com.bnrc.bnrcbus.module.version.VersionModel;
import com.bnrc.bnrcbus.network.RequestCenter;
import com.bnrc.bnrcbus.view.fragment.BaseFragment;
import com.bnrc.bnrcsdk.okhttp.listener.DisposeDataListener;
import com.bnrc.bnrcsdk.ui.viewpager.NoScrollViewPager;
import com.bnrc.bnrcsdk.ui.viewpager.ViewpagerIndicator;
import com.bnrc.bnrcsdk.ui.viewpager.VpAdapter;

import java.util.ArrayList;

/**
 * Created by apple on 2018/5/23.
 */

public class HomeFragment extends BaseFragment {

    private View mContentView;
    private VersionModel mVersionData;

    //viewpager相关
    private ViewpagerIndicator indicator;
    private NoScrollViewPager viewPager;
    private ArrayList<View> aList;
    private VpAdapter mAdapter;

    //滑动控件
    private NestedScrollView nestedScrollView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_home,container,false);
        initView();
        return mContentView;
    }

    public void initView(){
        viewPager = mContentView.findViewById(R.id.viewpager);
        nestedScrollView = mContentView.findViewById(R.id.scroll_view);
        nestedScrollView.setFillViewport(true);

        aList = new ArrayList<View>();
        LayoutInflater li = mContext.getLayoutInflater();
        aList.add(li.inflate(R.layout.fragment_near,null,false));
        aList.add(li.inflate(R.layout.fragment_collect,null,false));
        aList.add(li.inflate(R.layout.fragment_concern,null,false));
        mAdapter = new VpAdapter(aList);
        viewPager.setAdapter(mAdapter);

        //设置indicator
        indicator = mContentView.findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);


    }

    /**
     * 测试网络功能
     */

    private void test() {
        RequestCenter.requestVersionData(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                mVersionData = (VersionModel) responseObj;
                //更新UI
                showSuccessView();
            }

            @Override
            public void onFailure(Object reasonObj) {
                //显示请求失败View
                showErrorView();
            }
        });
    }

    //显示请求成功UI
    private void showSuccessView() {}

    private void showErrorView() {}
}
