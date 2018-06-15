package com.bnrc.bnrcsdk.ui.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by apple on 2018/6/5.
 */

public class VpAdapter extends PagerAdapter {

    private ArrayList<View> viewLists;

    String[] pageTitles = {"附近", "收藏", "提醒"};

    public VpAdapter() {
    }

    public VpAdapter(ArrayList<View> viewLists) {
        super();
        this.viewLists = viewLists;
    }

    @Override
    public int getCount() {
        return viewLists.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position % 3];
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewLists.get(position));
        return viewLists.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewLists.get(position));
    }
}
