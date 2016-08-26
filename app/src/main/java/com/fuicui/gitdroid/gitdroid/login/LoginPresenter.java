package com.fuicui.gitdroid.gitdroid.login;

import com.fuicui.gitdroid.gitdroid.commons.LogUtils;
import com.fuicui.gitdroid.gitdroid.login.model.AccessToken;
import com.fuicui.gitdroid.gitdroid.network.GithubApi;
import com.fuicui.gitdroid.gitdroid.network.GithubClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者：yuanchao on 2016/8/26 0026 14:02
 * 邮箱：yuanchao@feicuiedu.com
 */
public class LoginPresenter {

    private Call<AccessToken> tokenCall;

    /**
     * 登录，完成的工作：使用code 换取Token，再换取用户信息
     *
     * @param code
     */
    public void login(String code) {
        if (tokenCall != null) {
            tokenCall.cancel();
        }
        //获取Token
        tokenCall = GithubClient.getInstance().getOAuthToken(
                GithubApi.CLIENT_ID,
                GithubApi.CLIENT_SECRET,
                code);
        tokenCall.enqueue(tokenCallback);
    }

    //获取Token返回
    private Callback<AccessToken> tokenCallback = new Callback<AccessToken>() {
        @Override public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
            //成功返回
            if (response.isSuccessful()){
                LogUtils.d("token:"+response.body().getAccessToken());
            }else {
                LogUtils.d("token 没有成功返回");
            }

        }

        @Override public void onFailure(Call<AccessToken> call, Throwable t) {
            //请求失败
            LogUtils.d(t.getMessage());
        }
    };
}
