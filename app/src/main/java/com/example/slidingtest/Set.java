package com.example.slidingtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class Set extends AppCompatActivity {
    Button setbt;
    EditText setHour, setMin;
    RecycleadapterView recycleadapterView;
    //int currenth, currentm,i=0;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    ArrayList<Arrayclock> arrayclocks ;
    int seth;
    int setm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        setHour= findViewById(R.id.hoursedit);
        setMin =findViewById(R.id.minsedit);
        setbt = findViewById(R.id.stx);

        final ViewPageradapter viewPageradapter = new ViewPageradapter(getSupportFragmentManager());


        if (arrayclocks == null){
            arrayclocks = new ArrayList<>();
        }

        setbt.setOnClickListener(new View.OnClickListener() {           //set button on click lsitener to get data for the hours and setargument for demo
            @Override
            public void onClick(View view) {
                try{

                    seth = Integer.parseInt(String.valueOf(setHour.getText()));
                    setm = Integer.parseInt(String.valueOf(setMin.getText()));


                    setalarmmanager(); // Method to set the Alarmmanager, pendingIntent

                  Intent intent = new Intent(Set.this, MainActivity.class);
                    Bundle bundle = new Bundle();


                    bundle.putInt("seth", seth);
                    bundle.putInt("setm", setm);
                    intent.putExtra("bundle", bundle);
                    startActivity(intent);



                }catch (Exception e){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setMessage("Eneter a Valid Integer");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {


                        }
                    });
                    builder.setCancelable(true);

                    builder.create().show();

                }
            }
        });
    }
    public void setalarmmanager(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, seth);
        calendar.set(Calendar.MINUTE, setm);

        alarmManager =(AlarmManager)getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(Set.this, Broadcast.class);
        pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),1,intent, 0);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTime().getTime(), pendingIntent);

    }



}
