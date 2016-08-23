package com.fuicui.gitdroid.gitdroid.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fuicui.gitdroid.gitdroid.R;

/**
 * 作者：yuanchao on 2016/8/23 0023 11:22
 * 邮箱：yuanchao@feicuiedu.com
 */
public class SplashPagerFragment extends Fragment{


    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_pager,container,false);
    }
}
