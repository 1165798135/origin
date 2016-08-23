package com.fuicui.gitdroid.gitdroid.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fuicui.gitdroid.gitdroid.MainActivity;
import com.fuicui.gitdroid.gitdroid.R;

/**
 * 作者：yuanchao on 2016/8/23 0023 11:20
 * 邮箱：yuanchao@feicuiedu.com
 */
public class SplashActivity extends AppCompatActivity{

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button enter = (Button) findViewById(R.id.btnEnter);
        Button login = (Button) findViewById(R.id.btnLogin);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                SplashActivity.this.startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                //TODO
            }
        });
    }
}
