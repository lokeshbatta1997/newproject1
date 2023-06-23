package com.example.newproject1;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ProfileFragment extends Fragment {

   // @BindView(R.id.youtube)

    //
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {







        return inflater.inflate(R.layout.fragment_profile, container, false);

    }
}