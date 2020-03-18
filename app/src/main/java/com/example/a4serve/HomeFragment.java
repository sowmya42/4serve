package com.example.a4serve;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerView);
        MyAdapter listAdapter = new MyAdapter();
        Events[] fullList = listAdapter.getList();
        EventsList newList = new EventsList(5);
        for (int i = 0; i <= fullList.length; i++) {

            if (fullList[i].getFollow()) {
                newList.addEvents(fullList[i]);
            }
        }
        listAdapter.setList(newList);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
