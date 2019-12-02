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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Threelayout extends Fragment {
    View v;
    private Context mContext;
    ListView listview_play;
    ArrayList<ListViewItem_play> items_play;


    public Threelayout() {}
    @SuppressLint("ValidFragment")
    public Threelayout(Context mContext) {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.three_layout, container, false);
        listview_play = v.findViewById(R.id.list_play);
        items_play = new ArrayList<>();
        items_play.add(new ListViewItem_play("지퍼백 물감놀이"));
        items_play.add(new ListViewItem_play("풍선 감각 놀이"));
        items_play.add(new ListViewItem_play("풍선 배드민턴 놀이"));
        items_play.add(new ListViewItem_play("풍선 그리기 놀이"));
        items_play.add(new ListViewItem_play("우유통 볼링"));
        listview_play.setAdapter(new ListViewAdapter_play(mContext,items_play));

        return v;
    }
}
