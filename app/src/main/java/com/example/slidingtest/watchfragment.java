package com.example.slidingtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.tabs.TabLayout;

public class watchfragment extends Fragment {     //STOP WATCH FRAGMENT SECOND FRAGMENT IN VIEWPAGER





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.watchfrag, container, false);



      //  Toast.makeText(getActivity(), "yes", Toast.LENGTH_LONG).show();

        return view;
    }




}
