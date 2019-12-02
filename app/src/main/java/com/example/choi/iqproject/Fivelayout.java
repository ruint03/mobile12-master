package com.example.choi.iqproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Fragment;
import android.widget.Toast;

import java.util.ArrayList;

public class Fivelayout extends Fragment {
    View v;
    ListView listview_category;
    Context mContext;
    ArrayList<ListViewItem_content> items_content;
    ImageView imageView;

    public Fivelayout() {
    }

    @SuppressLint("ValidFragment")
    public Fivelayout(Context mContext) {
        this.mContext = mContext;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.five_layout, container, false);
        listview_category = v.findViewById(R.id.list_content);
        items_content = new ArrayList<>();
        items_content.add(new ListViewItem_content("테스트를 하기위한 제목 설정 중입니다", "관리자"));
        items_content.add(new ListViewItem_content("테스트를 하기위한 제목 설정 중입니다(2)", "관리자"));
        listview_category.setAdapter(new ListViewAdapter_content(mContext, items_content));
        imageView = v.findViewById(R.id.imageButton1);
        listview_category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getActivity(),items_content.get(i).getTitle(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),content.class);
                startActivity(intent);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),new_content.class);
                startActivity(intent);
            }
        });
        return v;

    }
}
