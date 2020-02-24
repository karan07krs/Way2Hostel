package com.example.way2hostel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {
    FrameLayout signup, signin;
    TextView signuptv, signintv, signuptv1, signintv1,signinbutton,signupgetotp,donthaveac, alreadyhaveac;
    LinearLayout signinlinear,signuplinear;
    EditText phoneNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        signup=(FrameLayout)findViewById(R.id.signupframe);
        signin=(FrameLayout)findViewById(R.id.loginframe);
        signuptv=(TextView)findViewById(R.id.signup);
        signintv=(TextView)findViewById(R.id.signin);
        signuptv1=(TextView)findViewById(R.id.signup1);
        signintv1=(TextView)findViewById(R.id.signin1);
        signinbutton=(TextView)findViewById(R.id.signinbutton);
        signupgetotp = (TextView) findViewById(R.id.signupgetotp);
        donthaveac=(TextView)findViewById(R.id.donthaveaccount);
        alreadyhaveac=(TextView)findViewById(R.id.alrhaveanaccount);
        signinlinear=(LinearLayout)findViewById(R.id.whensigninclicked);
        signuplinear=(LinearLayout)findViewById(R.id.whensignupclicked);

        phoneNo= (EditText)findViewById(R.id.signupphoneno);



        signuptv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup.setVisibility(View.VISIBLE);
                signin.setVisibility(View.INVISIBLE);
                signuplinear.setVisibility(View.VISIBLE);
                signinlinear.setVisibility(View.INVISIBLE);


            }
        });

        signintv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signin.setVisibility(View.VISIBLE);
                signup.setVisibility(View.INVISIBLE);

                signuplinear.setVisibility(View.INVISIBLE);
                signinlinear.setVisibility(View.VISIBLE);


            }
        });
        signuptv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup.setVisibility(View.VISIBLE);
                signin.setVisibility(View.INVISIBLE);
                signuplinear.setVisibility(View.VISIBLE);
                signinlinear.setVisibility(View.INVISIBLE);


            }
        });

        signintv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signin.setVisibility(View.VISIBLE);
                signup.setVisibility(View.INVISIBLE);

                signuplinear.setVisibility(View.INVISIBLE);
                signinlinear.setVisibility(View.VISIBLE);

            }
        });

        signupgetotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("hello"+phoneNo.getText().toString());
                Intent i=new Intent(loginActivity.this,verifyActivity.class);
                i.putExtra("phoneno",phoneNo.getText().toString());

                startActivity(i);


            }
        });

        donthaveac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup.setVisibility(View.VISIBLE);
                signin.setVisibility(View.INVISIBLE);
                signuplinear.setVisibility(View.VISIBLE);
                signinlinear.setVisibility(View.INVISIBLE);


            }
        });

        alreadyhaveac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin.setVisibility(View.VISIBLE);
                signup.setVisibility(View.INVISIBLE);

                signuplinear.setVisibility(View.INVISIBLE);
                signinlinear.setVisibility(View.VISIBLE);

            }
        });

    }
}
