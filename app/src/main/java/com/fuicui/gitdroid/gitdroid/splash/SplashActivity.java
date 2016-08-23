package com.fuicui.gitdroid.gitdroid.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fuicui.gitdroid.gitdroid.MainActivity;
import com.fuicui.gitdroid.gitdroid.R;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者：yuanchao on 2016/8/23 0023 11:20
 * 邮箱：yuanchao@feicuiedu.com
 */
public class SplashActivity extends AppCompatActivity{

//    @BindView(R.id.btnEnter) Button mBtnEnter;
//    @BindView(R.id.btnLogin) Button mBtnLogin;

    @BindString(R.string.app_name) String appName;

    @BindColor(R.color.colorAccent) int color;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btnLogin) void login(){
        //TODO 登录跳转
    }

    @OnClick(R.id.btnEnter) void enter(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
