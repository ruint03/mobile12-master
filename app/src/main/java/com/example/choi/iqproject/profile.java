package com.example.choi.iqproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    private Button logout,remove,revise;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);

        logout = (Button)findViewById(R.id.Logout);
        remove = (Button)findViewById(R.id.remove);
    }
}
