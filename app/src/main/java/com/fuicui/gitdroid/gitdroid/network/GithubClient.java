package com.fuicui.gitdroid.gitdroid.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：yuanchao on 2016/8/26 0026 09:33
 * 邮箱：yuanchao@feicuiedu.com
 */
public class GithubClient {

    private static GithubClient githubClient;
    private final GithubApi githubApi;

    public static GithubClient getInstance(){
        if (githubClient==null){
            githubClient = new GithubClient();
        }
        return githubClient;
    }

    private GithubClient(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //添加拦截器
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)

                //Retrofit 强大的功能：Gson转换器----将我们的数据请求的结果自动进行json转换，转换为我们需要的类型
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        githubApi = retrofit.create(GithubApi.class);
    }

    public GithubApi getGithubApi(){
        return githubApi;
    }
}
