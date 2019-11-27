package com.example.choi.iqproject;

import android.os.Bundle;

import androidx.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


public class Onelayout extends Fragment {
    View v;
    RadioGroup rg;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v= inflater. inflate(R.layout.one_layout,container,false);
        rg = (RadioGroup)v.findViewById(R.id.rg_1);
return v;
    }
}
