package com.example.choi.iqproject;

public class ListViewItem_comment {
    private String comment_writer;
    private String comment_content;

    public ListViewItem_comment(String writer, String content) {
        this.comment_writer = writer;
        this.comment_content = content;
    }

    public void setWriter(String writer) {
        comment_writer = writer;
    }

    public void setcontent(String content) {
        comment_content = content;
    }

    public String getWriter() {
        return this.comment_writer;
    }

    public String getComment_content() {
        return this.comment_content;
    }
}
