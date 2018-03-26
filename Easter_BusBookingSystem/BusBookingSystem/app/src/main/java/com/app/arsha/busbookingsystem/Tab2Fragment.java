package com.app.arsha.busbookingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;


//THIS IS FOR BOOKING
public class Tab2Fragment extends Fragment {
    String fromjson;
    String toJson;
    private static final String TAG = "Tab2Fragment";

    private int Date;
    private int month;
    private int year;

    private Button btnTEST;
    private Spinner from;
    Spinner TO;
    Button GoforCalender;

    ArrayList<String> fromList=new ArrayList<>();
    ArrayList<String> toList=new ArrayList<>();

    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference rootref=db.getReference();

    DatabaseReference userref=rootref.child("Travel");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main1,container,false);


        from=(Spinner)view.findViewById(R.id.from);
        TO=(Spinner)view.findViewById(R.id.to);
        final ArrayAdapter<String> fromadapter=new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1 ,fromList);
        final ArrayAdapter<String> toadapter=new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1 ,toList);
        from.setAdapter(fromadapter);
        TO.setAdapter(toadapter);


        userref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {//naan ida Oncreate() kku ulla poodura padiyaa idu total child a dataSnapshot a edukkum
                String value=dataSnapshot.getValue().toString();

                try {
                    JSONObject object=new JSONObject(value);
                    fromjson=object.getString("From");
                    toJson=object.getString("To");

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                fromList.add(fromjson);

                //This CODE IS TO GET RID OF DUPLICATE DATA IN ARRAY LIST
                HashSet hs = new HashSet();
                hs.addAll(fromList); // demoArrayList= name of arrayList from which u want to remove duplicates
                fromList.clear();
                fromList.addAll(hs);
                //
                fromadapter.notifyDataSetChanged();

                //This CODE IS TO GET RID OF DUPLICATE DATA IN ARRAY LIST
                HashSet hp = new HashSet();
                hp.addAll(toList); // demoArrayList= name of arrayList from which u want to remove duplicates
                toList.clear();
                toList.addAll(hp);
                //
                toList.add(toJson);
                toadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        GoforCalender=(Button)view.findViewById(R.id.calender);
        GoforCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),calenderActivity.class); //WHile We USE A FRAGMENT

                startActivity(intent);
            }
        });



        return view;
    }

}