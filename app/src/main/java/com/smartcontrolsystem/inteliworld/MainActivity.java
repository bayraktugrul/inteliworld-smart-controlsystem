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
    private boolean num1Bool =true;
    private boolean num2Bool =true;
    private boolean num3Bool =true;
    private boolean num4Bool =true;
    private boolean num5Bool =true;
    private boolean num6Bool =true;

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

                Boolean num1Value = map.get("num1");
                if(num1Value == true){
                    num1.setBackgroundColor(Color.GREEN);
                }
                else if(num1Value == false){
                    num1.setBackgroundColor(Color.RED);
                }

                Boolean num2Value = map.get("num2");
                if(num2Value == true){
                    num2.setBackgroundColor(Color.GREEN);
                }
                else if(num2Value == false){
                    num2.setBackgroundColor(Color.RED);
                }

                Boolean num3Value = map.get("num3");
                if(num3Value == true){
                    num3.setBackgroundColor(Color.GREEN);
                }
                else if(num3Value == false){
                    num3.setBackgroundColor(Color.RED);
                }

                Boolean num4Value = map.get("num4");
                if(num4Value == true){
                    num4.setBackgroundColor(Color.GREEN);
                }
                else if(num4Value == false){
                    num4.setBackgroundColor(Color.RED);
                }

                Boolean num5Value = map.get("num5");
                if(num5Value == true){
                    num5.setBackgroundColor(Color.GREEN);
                }
                else if(num5Value == false){
                    num5.setBackgroundColor(Color.RED);
                }

                Boolean num6Value = map.get("num6");
                if(num6Value == true){
                    num6.setBackgroundColor(Color.GREEN);
                }
                else if(num6Value == false){
                    num6.setBackgroundColor(Color.RED);
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
