package com.smartcontrolsystem.inteliworld;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.realtime.util.StringListReader;
import com.google.firebase.FirebaseApp;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button num1, num2, num3, num4, num5, num6;
    private Firebase mRef;
    private boolean num1Bool;
    private boolean num2Bool;
    private boolean num3Bool;
    private boolean num4Bool;
    private boolean num5Bool;
    private boolean num6Bool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://inteliworld-31e3b.firebaseio.com/");


        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase mRefChild = mRef.child("num1");
                mRefChild.setValue(num1Bool);
                if(num1Bool == true) num1Bool=false;
                else if(num1Bool == false) num1Bool=true;

            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase mRefChild = mRef.child("num2");
                mRefChild.setValue(num2Bool);
                if(num2Bool == true) num2Bool=false;
                else if(num2Bool == false) num2Bool=true;

            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase mRefChild = mRef.child("num3");
                mRefChild.setValue(num3Bool);
                if(num3Bool == true) num3Bool=false;
                else if(num3Bool == false) num3Bool=true;

            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase mRefChild = mRef.child("num4");
                mRefChild.setValue(num4Bool);
                if(num4Bool == true) num4Bool=false;
                else if(num4Bool == false) num4Bool=true;

            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase mRefChild = mRef.child("num5");
                mRefChild.setValue(num5Bool);
                if(num5Bool == true) num5Bool=false;
                else if(num5Bool == false) num5Bool=true;

            }
        });


        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Firebase mRefChild = mRef.child("num6");
                mRefChild.setValue(num6Bool);
                if(num6Bool == true) num6Bool=false;
                else if(num6Bool == false) num6Bool=true;

            }
        });


        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Boolean> map = dataSnapshot.getValue(Map.class);

                num1Bool = map.get("num1");
                if(num1Bool == true){
                    num1.setBackgroundResource(R.drawable.button_active);
                }
                else if(num1Bool == false){
                    num1.setBackgroundResource(R.drawable.button);
                }

                num2Bool= map.get("num2");
                if(num2Bool == true){
                    num2.setBackgroundResource(R.drawable.button_active);
                }
                else if(num2Bool == false){
                    num2.setBackgroundResource(R.drawable.button);
                }

                num3Bool = map.get("num3");
                if(num3Bool == true){
                    num3.setBackgroundResource(R.drawable.button_active);
                }
                else if(num3Bool == false){
                    num3.setBackgroundResource(R.drawable.button);
                }

                num4Bool = map.get("num4");
                if(num4Bool == true){
                    num4.setBackgroundResource(R.drawable.button_active);
                }
                else if(num4Bool == false){
                    num4.setBackgroundResource(R.drawable.button);
                }

                num5Bool = map.get("num5");
                if(num5Bool == true){
                    num5.setBackgroundResource(R.drawable.button_active);
                }
                else if(num5Bool == false){
                    num5.setBackgroundResource(R.drawable.button);
                }

                num6Bool = map.get("num6");
                if(num6Bool == true){
                    num6.setBackgroundResource(R.drawable.button_active);
                }
                else if(num6Bool == false){
                    num6.setBackgroundResource(R.drawable.button);
                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }


    public void init() {
        num1 = (Button)findViewById(R.id.num1);
        num2 = (Button)findViewById(R.id.num2);
        num3 = (Button)findViewById(R.id.num3);
        num4 = (Button)findViewById(R.id.num4);
        num5 = (Button)findViewById(R.id.num5);
        num6 = (Button)findViewById(R.id.num6);
    }



}
