package com.example.choi.iqproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class result extends AppCompatActivity {
    TextView avoid, sensor, seek, regist;
    int result_avoid, result_sensor, result_seek, result_resist;
    Button exit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        exit = findViewById(R.id.btn_exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();

            }
        });
//        View v = new View(this);
//        v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,1));
//        v.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT));
//        seek = findViewById(R.id.text_seek);
//        avoid = findViewById(R.id.text_avoid);
//        sensor = findViewById(R.id.text_sensor);
//        regist = findViewById(R.id.text_regist);
//
//        seek.setText(result_avoid);
//        avoid.setText(result_avoid);
//        sensor.setText(result_sensor);
//        regist.setText(result_resist);

    }
}
