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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Threelayout extends Fragment {
    View v;
    private Context mContext;
    ListView listView_play;
    ArrayList<ListViewItem_play> items;

    public Threelayout() {}
    @SuppressLint("ValidFragment")
    public Threelayout(Context mContext) {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.three_layout, container, false);
        listView_play = v.findViewById(R.id.list_play);
        items = new ArrayList<>();
        items.add(new ListViewItem_play("<1>", "감각행동 추구", "(Sensory seeking behaviors)"));
        items.add(new ListViewItem_play("<2>", "감각 회피 행동","(Sensory avoiding behaviors)"));
        listView_play.setAdapter(new ListViewAdapter_play(mContext, items));
        return v;
    }
}
