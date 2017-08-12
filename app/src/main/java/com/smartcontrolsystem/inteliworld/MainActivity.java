package com.smartcontrolsystem.inteliworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private Button num1;
    private Firebase mRef;


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
                mRefChild.setValue("false");

            }
        });



    }


    public void init() {
        num1 = (Button)findViewById(R.id.num1);
    }



}
