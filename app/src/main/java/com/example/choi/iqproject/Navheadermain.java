package com.example.choi.iqproject;

import android.app.Activity;
import android.app.NativeActivity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Navheadermain extends Activity {
    Button loginmove;
    TextView user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);
        user_id = (TextView) findViewById(R.id.text_id);
        loginmove = findViewById(R.id.loginmove);
        loginmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Navheadermain.this, Loginlayout.class);
                startActivity(intent);

            }


        });


    }


}
