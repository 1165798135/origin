package com.fuicui.gitdroid.gitdroid.github;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fuicui.gitdroid.gitdroid.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HotRepoListFragment extends Fragment {


    //主要为了展示数据
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_repo_list, container, false);
    }

    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = (ListView) view.findViewById(R.id.lvRepos);

        String[] data = {"1111111111","2222222222","3333333333"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,data);

        listView.setAdapter(adapter);
    }

}
