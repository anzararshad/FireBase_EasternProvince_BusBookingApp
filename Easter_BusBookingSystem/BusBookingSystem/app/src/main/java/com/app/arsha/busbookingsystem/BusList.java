package com.app.arsha.busbookingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BusList extends AppCompatActivity {

    Intent intent=new Intent();
    public String datePicked;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference rootref=db.getReference();//THIS is to go to table column


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_list);

        Bundle extras = intent.getExtras();
        if(extras != null) {
                datePicked= extras.getString("Date");
        }
    }
}
