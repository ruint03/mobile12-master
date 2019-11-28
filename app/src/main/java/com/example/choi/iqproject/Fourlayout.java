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
import android.widget.ListView;

import java.util.ArrayList;

public class Fourlayout extends Fragment {
    View v;
    private Context mContext;
    ListView listview_category;
    ArrayList<ListViewItem_tip> items_tip;

    public Fourlayout(){}
    @SuppressLint("ValidFragment")
    public Fourlayout(Context mContext){this.mContext = mContext;}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.four_layout, container, false);
        listview_category = v.findViewById(R.id.list_tip);
        items_tip = new ArrayList<>();
        items_tip.add(new ListViewItem_tip("1. 수면"));
        items_tip.add(new ListViewItem_tip("2. 옷입기"));
        items_tip.add(new ListViewItem_tip("3. 몸치장"));
        items_tip.add(new ListViewItem_tip("4. 세수 손씻기 그리고 샤워하기"));
        items_tip.add(new ListViewItem_tip("5. 화장실 훈련"));
        items_tip.add(new ListViewItem_tip("6. 이 닦기"));
        items_tip.add(new ListViewItem_tip("7. 먹기"));
        listview_category.setAdapter(new ListViewAdapter_tip(mContext,items_tip));

    return v;
    }
}