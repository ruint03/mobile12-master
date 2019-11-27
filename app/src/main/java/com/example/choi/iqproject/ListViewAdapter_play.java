package com.example.choi.iqproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ListViewAdapter_play extends BaseAdapter {
    Context mContext;
    private ArrayList<ListViewItem_play> listViewItemList;

    public ListViewAdapter_play(Context mContext, ArrayList<ListViewItem_play> items) {
        this.mContext = mContext;
        listViewItemList = items;
    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }
        TextView titleTextView = convertView.findViewById(R.id.text_title);
        TextView subtitleTextView = convertView.findViewById(R.id.textsub_title);
        TextView indexTextView = convertView.findViewById(R.id.text_index);

        ListViewItem_play listViewItem_play = listViewItemList.get(position);

        titleTextView.setText(listViewItem_play.getTitle());
        subtitleTextView.setText(listViewItem_play.getsubTitle());
        indexTextView.setText(listViewItem_play.getindex());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(pos){
                    case 0:
                }

            }
        });

        return convertView;
    }


}

