package com.example.choi.iqproject;

import android.graphics.drawable.Drawable;

public class ListViewItem_play {
    private String index_num;
    private String title_str;
    private String sub_title_str;

    public ListViewItem_play(String index_num, String title_str, String sub_title_str) {
        this.index_num = index_num;
        this.title_str = title_str;
        this.sub_title_str = sub_title_str;
    }

    public void setTitle(String title) {
        title_str = title;
    }

    public void setSub_title(String sub_title) {
        sub_title_str = sub_title;
    }

    public void setIndex(String index) {
        index_num = index;
    }

    public String getTitle() {
        return this.title_str;
    }

    public String getsubTitle() {
        return this.sub_title_str;
    }

    public String getindex() {
        return this.index_num;
    }
}