package com.example.slidingtest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class setfrag extends DialogFragment  {
    Button setbt;
    EditText setHour, setMin;
    int seth;
    int setm;

public interface SetTime{  // interface
    void passdata(int x);
}
SetTime setTime;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {

            setTime = (SetTime)getParentFragment(); /// mtrying to get demofragmet
        }catch (Exception e ){
            Toast.makeText(getContext(), String.valueOf(e), Toast.LENGTH_LONG).show();

        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.setfrag, null);
        setHour= (EditText)view.findViewById(R.id.hoursedit);
        setMin =(EditText)view.findViewById(R.id.minsedit);
        setbt = (Button)view.findViewById(R.id.stx);




        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setPositiveButton(" Set", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                try {



                    seth = Integer.parseInt(String.valueOf(setHour.getText()));
                     setm = Integer.parseInt(String.valueOf(setMin.getText()));

                     //pass data to the interface

                      setTime.passdata(seth);

                }catch (Exception e){
                    Toast.makeText(getActivity(), String.valueOf(e), Toast.LENGTH_LONG).show();

                }

            }
        });



        builder.setView(view);

        return builder.create();
    }
}
