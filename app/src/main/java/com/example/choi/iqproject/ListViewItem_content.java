package com.example.choi.iqproject;

import android.widget.ListView;

public class ListViewItem_content {
    private String title;
    private String writer;

    public ListViewItem_content(String title, String writer) {
        this.title = title;
        this.writer = writer;
    }

    public void setTitle(String content_title) {
        title = content_title;
    }

    public void setWriter(String content_writer) {
        writer = content_writer;
    }

    public String getTitle() {
        return this.title;
    }

    public String getWriter() {
        return this.writer;
    }


}
