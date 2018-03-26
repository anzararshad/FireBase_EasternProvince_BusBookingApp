package com.app.arsha.busbookingsystem;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.Calendar;

/**
 * Created by arsha on 10/20/2017.
 */

public class calenderActivity extends AppCompatActivity {
     private static final String TAG="CalenderActivity";
    private CalendarView calendarView;
    private String dateTOpass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender);
        calendarView=(CalendarView)findViewById(R.id.calendarView);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                String mon=Integer.toString(month);
                String yea=Integer.toString(year);
                String day=Integer.toString(dayOfMonth);

                dateTOpass=yea+"-"+mon+"-"+day;


                Intent passToBusList=new Intent(calenderActivity.this,BusList.class);
                passToBusList.putExtra("Date",dateTOpass);
                startActivity(passToBusList);
            }
        });
    }
}
