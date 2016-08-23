package com.fuicui.gitdroid.gitdroid.splash.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.fuicui.gitdroid.gitdroid.R;

/**
 * 作者：yuanchao on 2016/7/26 0026 10:53
 * 邮箱：yuanchao@feicuiedu.com
 */
public class Pager2 extends FrameLayout {

   /*三个构造方法
   * 1.一般仅在代码中使用
   * 2.在布局中也有使用
   * 3.在布局中使用，并且设置了Style
   * */
    public Pager2(Context context) {
        this(context,null);
    }

    public Pager2(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Pager2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_2,this,true);
    }
}
