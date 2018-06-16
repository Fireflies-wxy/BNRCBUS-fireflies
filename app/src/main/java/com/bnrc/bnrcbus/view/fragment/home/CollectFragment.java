package com.bnrc.bnrcbus.view.fragment.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bnrc.bnrcbus.R;
import com.bnrc.bnrcbus.view.fragment.BaseFragment;

/**
 * Created by apple on 2018/6/4.
 */

public class CollectFragment extends BaseFragment {

    private static final String TAG = "CollectFragment";

    private View mContentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_collect,container,false);
        Log.i(TAG,TAG);
        return mContentView;
    }
}
