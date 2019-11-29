package com.example.choi.iqproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


public class Onelayout extends Fragment {
    Context mContext;
    View v;
    RadioGroup[] rg;
    String id = "R.id.rg_";
    String packName = mContext.getPackageName();
    public Onelayout() {}
    @SuppressLint("ValidFragment")
    public Onelayout(Context mContext) {
        this.mContext = mContext;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v= inflater. inflate(R.layout.one_layout,container,false);
        for(int i = 1; i<=34;i++){
            int k = getResources().getIdentifier("rg_"+i,"id",packName);
            rg[i] = v.findViewById(k);
        }
return v;
    }
}
