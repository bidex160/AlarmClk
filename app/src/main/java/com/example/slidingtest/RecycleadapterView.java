package com.example.slidingtest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleadapterView extends RecyclerView.Adapter<RecycleadapterView.ViewHolder> {
      ArrayList<Arrayclock> arrayclocks = new ArrayList<>();
      Context context;


    public RecycleadapterView(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclelayout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.hourTxt.setText(String.valueOf(arrayclocks.get(position).getHours()));
        holder.minTxt.setText(String.valueOf(arrayclocks.get(position).getMin()));


        //switch button listener

       holder.sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
              if (b){
                  Toast.makeText(context, String.valueOf(b), Toast.LENGTH_LONG).show();
                  Bundle bundle = new Bundle();

              }
              else {
                  Toast.makeText(context, String.valueOf(b), Toast.LENGTH_LONG).show();
              }
           }
       });

    }


    @Override
    public int getItemCount() {
        return arrayclocks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView hourTxt, minTxt;
        CardView cardView;
        Switch sw;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hourTxt = (TextView)itemView.findViewById(R.id.hourTxt);
            minTxt = (TextView)itemView.findViewById(R.id.minsTxt);

            sw = (Switch)itemView.findViewById(R.id.s);
        }
    }

    public void setArrayclocks(ArrayList<Arrayclock> arrayclocks) {
        this.arrayclocks = arrayclocks;
        notifyDataSetChanged();
    }
}
