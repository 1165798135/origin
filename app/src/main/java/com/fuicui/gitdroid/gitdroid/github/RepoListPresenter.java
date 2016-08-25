package com.fuicui.gitdroid.gitdroid.github;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务类，主要完成数据加载，通知视图进行改变
 * 作者：yuanchao on 2016/8/24 0024 16:29
 * 邮箱：yuanchao@feicuiedu.com
 */
public class RepoListPresenter {
    private RepoPtrView repoPtrView;
    private List<String> list;

    public RepoListPresenter(RepoPtrView repoPtrView) {

        this.repoPtrView = repoPtrView;
        list = new ArrayList<>();
    }

    public void refresh(){
        //显示刷新
        repoPtrView.showContentView();
        new Refresh().execute();
    }

    class Refresh extends AsyncTask<Void,Void,Void> {

        @Override protected Void doInBackground(Void... params) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            for (int i = 0; i < 20; i++) {
                list.add("刷新出来的数据"+i);
            }
            repoPtrView.refreshData(list);
            //停止刷新
            repoPtrView.stopRefresh();
        }
    }
}
