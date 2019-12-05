package com.example.choi.iqproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class result extends AppCompatActivity {
    int result_avoid, result_sensor, result_seek, result_resist;
    Button exit;
    TextView seek, avoid, sensor, regist;
    int score_avoid,score_sensor,score_regist,score_seek;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent intent = getIntent();
        seek = (TextView)findViewById(R.id.text_seek);
        avoid = (TextView)findViewById(R.id.text_avoid);
        sensor = (TextView)findViewById(R.id.text_sensor);
        regist = (TextView)findViewById(R.id.text_regist);
        score_seek = intent.getIntExtra("seek");
        seek.setText(String.valueOf(score_seek));
        avoid.setText(String.valueOf(score_avoid));
        sensor.setText(String.valueOf(score_sensor));
        regist.setText(String.valueOf(score_regist));
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
    }
}
