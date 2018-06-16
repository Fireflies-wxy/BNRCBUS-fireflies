package com.bnrc.bnrcbus.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bnrc.bnrcbus.R;
import com.bnrc.bnrcbus.module.version.VersionModel;
import com.bnrc.bnrcbus.network.RequestCenter;
import com.bnrc.bnrcbus.view.fragment.BaseFragment;
import com.bnrc.bnrcsdk.okhttp.listener.DisposeDataListener;

/**
 * Created by apple on 2018/6/4.
 */

public class NearFragment extends BaseFragment{

    private static final String TAG = "NearFragment";

    private TextView near;
    private VersionModel mVersionData;
    private View mContentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_near,container,false);
        near = mContentView.findViewById(R.id.tv_near);
        Log.i(TAG,TAG);
        test();
        return mContentView;
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
    private void showSuccessView() {
        Log.i(TAG,mVersionData.Info);
        near.setText(mVersionData.Info);
    }

    private void showErrorView() {
        near.setText("error");
    }


}
