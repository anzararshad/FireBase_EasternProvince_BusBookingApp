package com.app.arsha.busbookingsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Mypage extends AppCompatActivity {
    Button signout;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mauthStateListener;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mauthStateListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        signout=(Button)findViewById(R.id.logout);

        mAuth=FirebaseAuth.getInstance();
//MADE CHANGE HERE
        mauthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    startActivity(new Intent(Mypage.this,login.class));//source then Destination CLass
                }


            }
        };

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           mAuth.signOut();
            }
        });

    }
}
