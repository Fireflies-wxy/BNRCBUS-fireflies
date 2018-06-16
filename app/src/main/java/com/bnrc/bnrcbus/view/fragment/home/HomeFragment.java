package com.bnrc.bnrcbus.view.fragment.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bnrc.bnrcbus.R;
import com.bnrc.bnrcbus.module.version.VersionModel;
import com.bnrc.bnrcbus.network.RequestCenter;
import com.bnrc.bnrcbus.view.fragment.BaseFragment;
import com.bnrc.bnrcsdk.okhttp.listener.DisposeDataListener;
import com.bnrc.bnrcsdk.ui.viewpager.VpAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2018/5/23.
 */

public class HomeFragment extends BaseFragment {

    private static final String TAG = "HomeFragment";

    private View mContentView;

    //TabLayout
    private TabLayout mTabLayout;
    //ViewPager
    private ViewPager mViewPager;
    //Title
    private List<String> mTitle;
    //Fragment
    private List<Fragment> mFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_home,container,false);
        initData();
        initView();
        return mContentView;
    }

    //初始化数据
    private void initData() {
        mTitle = new ArrayList<>();
        mTitle.add(getString(R.string.text_near));
        mTitle.add(getString(R.string.text_collect));
        mTitle.add(getString(R.string.text_concern));

        mFragment = new ArrayList<>();
        mFragment.add(new NearFragment());
        mFragment.add(new CollectFragment());
        mFragment.add(new ConcernFragment());
    }

    public void initView(){
        mTabLayout = mContentView.findViewById(R.id.mTabLayout);
        mViewPager = mContentView.findViewById(R.id.mViewPager);
        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());

        //mViewPager滑动监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            //选中的item
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            //返回item的个数
            @Override
            public int getCount() {
                return mFragment.size();
            }

            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });
        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
