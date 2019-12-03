package com.example.choi.iqproject;

//java.lang.IllegalStateException: The specified child already has a parent. You must call removeView() on the child's parent first.

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
    ListView listview_category, listview_content;
    ArrayList<ListViewItem_q> items_q;
    ArrayList<ListViewItem_content> items_content;
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
        listview_content = v.findViewById(R.id.list_mtm);
        items_content = new ArrayList<>();
        items_q = new ArrayList<>();
        items_q.add(new ListViewItem_q("<1>","감각 행동 추구","(Sensory seeking behaviors)"));
        items_q.add(new ListViewItem_q("<2>","감각 회피 행동","(Sensory avoiding behaviors)"));
        items_content.add(new ListViewItem_content("테스트를 하기위한 제목 설정 중입니다", "관리자"));
        items_content.add(new ListViewItem_content("테스트를 하기위한 제목 설정 중입니다(2)", "관리자"));
        listview_category.setAdapter(new ListViewAdapter_q(mContext, items_q));
        listview_content.setAdapter(new ListViewAdapter_content(mContext,items_content));
        return v;
    }
    private void changeView(int index){
        FrameLayout frame = (FrameLayout) v.findViewById(R.id.frame_q);

        frame.removeViewAt(0);
        switch (index){
            case 0:
                frame.addView(listview_category);
                listview_content.setVisibility(View.GONE);
                frame.removeView(listview_content);
                break;
            case 1:
                frame.addView(listview_content);
                frame.removeAllViews();
                listview_category.setVisibility(View.GONE);

                break;
        }
    }

}