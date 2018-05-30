package com.bnrc.bnrcbus.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bnrc.bnrcbus.R;

public class BaseFragment extends Fragment{

    private static final String TAG = BaseFragment.class.getSimpleName();

    protected Activity mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i(TAG, this.getClass().getSimpleName() + "onCreateView");

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}