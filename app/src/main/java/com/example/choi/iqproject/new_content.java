package com.example.choi.iqproject;

        import android.content.Context;
        import android.os.Bundle;
        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import android.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class new_content extends Fragment {
    View v;
    String board_title, board_content;
    private Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.new_content, container, false);
       final EditText title, content;
       context = container.getContext();
        title = (EditText)v.findViewById(R.id.title);
        content = (EditText)v.findViewById(R.id.content);
        Button write = (Button)v.findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(title.getText().toString().length()==0){
                    Toast.makeText(context,"제목을 입력하세요",Toast.LENGTH_SHORT).show();
                    title.requestFocus();
                    return;
                }
                if(content.getText().toString().length()==0){
                    Toast.makeText(context,"내용을 입력하세요",Toast.LENGTH_SHORT).show();
                    content.requestFocus();
                    return;
                }
                board_title=title.getText().toString();
                board_content = content.getText().toString();
                
            }
        });
        return v;
    }
}
