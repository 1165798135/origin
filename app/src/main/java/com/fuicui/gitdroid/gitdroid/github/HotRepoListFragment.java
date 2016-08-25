package com.fuicui.gitdroid.gitdroid.github;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fuicui.gitdroid.gitdroid.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.header.StoreHouseHeader;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotRepoListFragment extends Fragment implements RepoPtrView {


    @BindView(R.id.lvRepos) ListView lvRepos;
    @BindView(R.id.ptrClassicFrameLayout) PtrClassicFrameLayout ptrFrameLayout;
    @BindView(R.id.emptyView) TextView emptyView;
    @BindView(R.id.errorView) TextView errorView;

    private List<String> data;

    private RepoListPresenter presenter;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_repo_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new RepoListPresenter(this);

        //初始添加数据
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("测试数据"+i);
        }
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,data);
        lvRepos.setAdapter(adapter);

        initPullToRefresh();
        if (adapter.getCount()==0){
            ptrFrameLayout.postDelayed(new Runnable() {
                @Override public void run() {
                    ptrFrameLayout.autoRefresh();
                }
            },200);
        }
    }

    private void initPullToRefresh() {
        // 使用当前对象做为key，来记录上一次的刷新时间,如果两次下拉太近，将不会触发新刷新
        ptrFrameLayout.setLastUpdateTimeRelateObject(this);
        // 关闭header所用时长
        ptrFrameLayout.setDurationToCloseHeader(1500);
        // 以下代码（只是修改了header样式）
        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.initWithString("I LIKE " + " JAVA");
        header.setPadding(0, 60, 0, 60);
        // 修改Ptr的HeaderView效果
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setBackgroundResource(R.color.colorRefresh);


        // 下拉刷新监听处理
        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
            // 当你"下拉时",将触发此方法
            @Override public void onRefreshBegin(PtrFrameLayout frame) {
                // 去做数据的加载，做具体的业务
                // 也就是说，你要抛开视图，到后台线程去做你的业务处理(数据刷新加载)
                presenter.refresh();
            }
        });
    }


    //下拉刷新刷新的时候视图
    /**
     * 1.显示刷新,显示刷新的视图
     * 2.停止刷新
     * 3.加载错误、网络加载失败
     * 4.刷新的数据为空，空页面
     * 5.拿到刷新得到数据
     */
    @Override public void refreshData(List<String> list) {
        data.clear();
        data.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override public void showContentView() {
        ptrFrameLayout.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
    }

    @Override public void stopRefresh() {
        ptrFrameLayout.refreshComplete();
    }

    @Override public void showEmptyView() {
        ptrFrameLayout.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
    }

    @Override public void showErrorView(String errormsg) {
        ptrFrameLayout.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }
}
