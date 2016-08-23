package com.fuicui.gitdroid.gitdroid.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.fuicui.gitdroid.gitdroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * 作者：yuanchao on 2016/8/23 0023 11:22
 * 邮箱：yuanchao@feicuiedu.com
 */
public class SplashPagerFragment extends Fragment {


    @BindView(R.id.ivPhoneFont) ImageView ivPhoneFont;
    @BindView(R.id.layoutPhone) FrameLayout layoutPhone;
    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.indicator) CircleIndicator indicator;
    @BindView(R.id.content) FrameLayout content;

    private SplashPagerAdapter adapter;

    @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_pager, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new SplashPagerAdapter(getContext());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);

    }
}
