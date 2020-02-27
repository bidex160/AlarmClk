package com.example.slidingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity" ;
    ViewPageradapter viewPageradapter;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager =  findViewById(R.id.pager);
        viewPageradapter = new ViewPageradapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPageradapter);

        tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);



          try {
              Intent intent = getIntent();
              Bundle bundle = intent.getBundleExtra("bundle");
              if (bundle != null){
                  int seth = bundle.getInt("seth", -1);
                  int setm = bundle.getInt("setm", -1);
            //     Toast.makeText(this, String.valueOf(seth), Toast.LENGTH_LONG).show();


              }
          }catch (Exception e){
              Toast.makeText(this, String.valueOf(e), Toast.LENGTH_LONG).show();

          }

    }


/*

 @Override
    public void sendmessage(String x) {
        try {

          //  setfrag setfrag = (setfrag)getSupportFragmentManager().findFragmentById(R.id)
         //  watchfragment w = (watchfragment)getSupportFragmentManager().findFragmentById(R.id.pager+0);
           watchfragment watchfragment = new watchfragment();
           Toast.makeText(this, x , Toast.LENGTH_LONG).show();
           Bundle bundle = new Bundle();
           bundle.putString("x", x);
           watchfragment.setArguments(bundle);


        }catch (Exception e){
            Toast.makeText(this, String.valueOf(e), Toast.LENGTH_LONG).show();
        }


    }*/

}
