package com.fuicui.gitdroid.gitdroid.github.hotuser;

import com.fuicui.gitdroid.gitdroid.commons.LogUtils;
import com.fuicui.gitdroid.gitdroid.login.model.User;
import com.fuicui.gitdroid.gitdroid.network.GithubClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 123 on 2016/8/30.
 */
public class HotUserPresenter {

    public interface HotUserView{
        /**
         * 1.显示刷新视图
         2.获取到数据，通知视图添加数据
         3.停止刷新
         4.加载失败，失败信息
         5.加载数据为空
         */

        void showRefreshView();

        void refreshData(List<User> users);

        void stopRefresh();

        void showMessage(String msg);

        void showErrorView();

        void showEmptyView();
    }

    private int nextPage = 1;
    private Call<HotUserResult> userCall;
    private HotUserView hotUserView;

    public HotUserPresenter(HotUserView hotUserView) {
        this.hotUserView = hotUserView;
    }

    public void refresh(){
        if (userCall!=null){
            userCall.cancel();
        }
        userCall = GithubClient.getInstance().searchUsers("followers:>1000", nextPage);
        userCall.enqueue(userCallback);
    }

    private Callback<HotUserResult> userCallback = new Callback<HotUserResult>() {
        @Override
        public void onResponse(Call<HotUserResult> call, Response<HotUserResult> response) {
            if (response.isSuccessful()){
                HotUserResult hotUserResult = response.body();
                if (hotUserResult==null){
                    //显示加载的结果为空
                }
                //通知视图进行数据填充
                List<User> users = hotUserResult.getUsers();
                hotUserView.refreshData(users);
                hotUserView.stopRefresh();
            }
            LogUtils.d("response 响应码："+response.code());
        }

        @Override
        public void onFailure(Call<HotUserResult> call, Throwable t) {
            LogUtils.d(t.getMessage());
        }
    };

}
