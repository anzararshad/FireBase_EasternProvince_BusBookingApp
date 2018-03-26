package com.app.arsha.busbookingsystem;

/**
 * Created by arsha on 10/20/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by User on 2/28/2017.
 */

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    Button signout;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mauthStateListener;

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mauthStateListener);
    }

    private Button btnTEST;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main2,container,false);

        signout=(Button)view.findViewById(R.id.signOut);

        mAuth=FirebaseAuth.getInstance();
//MADE CHANGE HERE
        mauthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    startActivity(new Intent(getActivity().getApplicationContext(),login.class));//source then Destination CLass
                }


            }
        };

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });


        return view;
    }
}