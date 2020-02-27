package com.example.slidingtest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class demofragment extends Fragment implements setfrag.SetTime { // FIRST FRAGMET IN VIEW PAGER    demofragmet For ALARM

    TextView textView;
   private RecyclerView recyclerView;
   private ArrayList<Arrayclock> arrayclocks ;
   private ImageView addimg;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");

        View view = inflater.inflate(R.layout.demofrag,container,false );



        addimg = view.findViewById(R.id.addv);
        recyclerView = view.findViewById(R.id.rec);
        RecycleadapterView recycleadapterView = new RecycleadapterView(getContext());
        recyclerView.setAdapter(recycleadapterView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        if (arrayclocks==null){
            arrayclocks= new ArrayList<>();
        }

        //add new alarm to launch set.class Activity


        addimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setfrag setfrag = new setfrag();
                setfrag.show(getFragmentManager(), "Set");

            }
        });




        //Toast.makeText(getActivity().getBaseContext(), String.valueOf(seth), Toast.LENGTH_LONG).show();




            //  arrayclocks.add(new Arrayclock(4, 30));

        recycleadapterView.setArrayclocks(arrayclocks);



        return view;
    }


    @Override
    public void passdata(int x) {

        Toast.makeText(getContext(), String.valueOf(x), Toast.LENGTH_LONG).show(); // printing the value of the result getting for the interface to check if its not null
    }
}
