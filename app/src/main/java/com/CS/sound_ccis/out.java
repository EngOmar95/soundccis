package com.CS.sound_ccis;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.CS.sound_ccis.R;


public class out extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent =new Intent(getContext(),logout.class);

        startActivity(intent);
        return inflater.inflate(R.layout.fragment_out, container, false);
    }
}