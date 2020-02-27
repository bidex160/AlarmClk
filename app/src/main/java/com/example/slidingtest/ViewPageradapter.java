package com.example.slidingtest;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageradapter extends FragmentStatePagerAdapter  {
    Context context;

    public ViewPageradapter(FragmentManager fm) {
        super(fm);
    }




    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                 // To display demofragmet for Alarm
                  demofragment demofragment = new demofragment();

                Bundle bundle = new Bundle();
                bundle.putString("message", "Alarm");


                demofragment.setArguments(bundle);

                return demofragment;
            case 1:
                // to display Stopwatch fragment for the stopwatch
                watchfragment watchfragment = new watchfragment();
               // position = position+1;
                Bundle bundlew = new Bundle();
                bundlew.putString("message", "Stopwatch");
               watchfragment.setArguments(bundlew);
                return watchfragment;
                default:
                    return null;
        }


    }



    @Override
    public int getCount() {
        //im using to fragment demofrag and watchfrag
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                // To set the title of Tablayout for Alarm
                return "Alarm";
            case 1:
                // To set title of tablayout for Stopwatch
                return "StopWatch";

            default:
                return null;
        }


    }
}
