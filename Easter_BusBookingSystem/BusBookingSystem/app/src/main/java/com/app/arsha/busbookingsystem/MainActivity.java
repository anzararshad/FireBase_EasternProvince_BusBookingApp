package com.app.arsha.busbookingsystem;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView ii=(ImageView)findViewById(R.id.img);
        ii.animate().alpha(0).setDuration(3000);
        ImageView img2=(ImageView)findViewById(R.id.and);
        img2.animate().alpha(1).setDuration(4000);


        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                GotoLogin();
            }
        },5000);


    }
    public void GotoLogin(){
        startActivity(new Intent(MainActivity.this,login.class));
    }
}
