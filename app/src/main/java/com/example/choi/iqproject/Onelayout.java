package com.example.choi.iqproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;


public class Onelayout extends Fragment {
    Context mContext;
    View v;
//    String packName = mContext.getPackageName();
    RadioGroup[] rg;
    String id = "R.id.rg_";
    Button done;

    public Onelayout() {
    }

    @SuppressLint("ValidFragment")
    public Onelayout(Context mContext) {
        this.mContext = mContext;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.one_layout, container, false);
        for (int i = 1; i <= 34; i++) {
//            int k = getResources().getIdentifier("rg_" + i, "id",mContext.getPackageName() );
//            rg[i] = v.findViewById(k);
        }
        done = v.findViewById(R.id.btn_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),result.class);
                startActivity(intent);
            }
        });
        return v;
    }
}
