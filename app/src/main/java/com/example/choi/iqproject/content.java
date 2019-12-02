package com.example.choi.iqproject;

        import android.os.Bundle;
        import android.widget.ListView;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

        import java.util.ArrayList;

public class content extends AppCompatActivity {
    ListView listview_content;
    ArrayList<ListViewItem_comment> items_comment;
    TextView writer, content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        listview_content = findViewById(R.id.list_comment);
        items_comment = new ArrayList<>();
        items_comment.add(new ListViewItem_comment("관리자", "댓글 테스트입니다."));
        items_comment.add(new ListViewItem_comment("관리자", "댓글 테스트입니다(2)."));
        listview_content.setAdapter(new ListViewAdapter_comment(this, items_comment));
    }
}
