package com.example.slidingtest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class demofragment extends Fragment {
    TextView textView;
    RecyclerView recyclerView;
    ArrayList<Arrayclock> arrayclocks ;
    ImageView addimg;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();

        if (bundle!=null){
        int seth = bundle.getInt("seth", -1);
       if (seth != -1){
            Toast.makeText(getContext(), String.valueOf(seth), Toast.LENGTH_LONG).show();
        }
    }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.demofrag,container,false );


        addimg = (ImageView)view.findViewById(R.id.addv);
        recyclerView = (RecyclerView)view.findViewById(R.id.rec);
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
                Intent intent = new Intent(getContext(), Set.class);
                startActivity(intent);
            }
        });


        //get  set hours and minute from set Activity
           Bundle bundle = getArguments();
           int x = bundle.getInt("seth", -1);
           int y = bundle.getInt("seth", -1);
          if (x != -1){
              Toast.makeText(getContext(), String.valueOf(x), Toast.LENGTH_LONG).show();
         }

            //  arrayclocks.add(new Arrayclock(4, 30));

        recycleadapterView.setArrayclocks(arrayclocks);



        return view;
    }
}
