package com.example.choi.iqproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class Twolayout extends Fragment {
    View v;
    private Context mContext;
    ListView listview_category;
    ArrayList<ListViewItem_q> items_q;
    public Twolayout() {}

    @SuppressLint("ValidFragment")
    public Twolayout(Context mContext) {this.mContext = mContext;}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.two_layout, container, false);
        TabLayout tabLayout = (TabLayout)v.findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                changeView(pos);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        listview_category = v.findViewById(R.id.list_q);
        items_q = new ArrayList<>();
        items_q.add(new ListViewItem_q("<1>","감각 행동 추구","(Sensory seeking behaviors)"));
        items_q.add(new ListViewItem_q("<2>","감각 회피 행동","(Sensory avoiding behaviors)"));
        listview_category.setAdapter(new ListViewAdapter_q(mContext, items_q));
        return v;
    }
    private void changeView(int index){
        FrameLayout frame = (FrameLayout) v.findViewById(R.id.frame_q);
        frame.removeViewAt(0);
        switch (index){
            case 0:
                frame.addView(listview_category);
                break;
            case 1:
//                frame.addView("게시판 리스트뷰");
                break;
        }
    }

}