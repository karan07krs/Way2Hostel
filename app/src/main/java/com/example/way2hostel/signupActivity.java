package com.example.way2hostel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class signupActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    EditText emailtextview;
    EditText password;
    EditText cpassword;
    TextView signup;
    ImageView back;
    String phoneno;
    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;
    RadioGroup gender;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        database =FirebaseDatabase.getInstance();

        firebaseAuth=FirebaseAuth.getInstance();
        phoneno=firebaseAuth.getCurrentUser().getPhoneNumber();
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        gender=(RadioGroup)findViewById(R.id.radiogrp);
        firstName = (EditText) findViewById(R.id.signupfirstname);
        lastName = (EditText) findViewById(R.id.signuplastname);
        password = (EditText) findViewById(R.id.signuppassword);
        cpassword = (EditText) findViewById(R.id.signupconfirmpassword);
        emailtextview = (EditText) findViewById(R.id.signupemail);
        signup = (TextView) findViewById(R.id.createaccount);
        back=(ImageView) findViewById(R.id.imageView_back);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(signupActivity.this,loginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void saveUser() {

        String fname = firstName.getText().toString().trim();
        String lname = lastName.getText().toString().trim();
        RadioButton radioSexButton;
        final String e_mail = emailtextview.getText().toString().trim();
        final String pass = password.getText().toString().trim();
        String cpass = cpassword.getText().toString().trim();
        int selectedId=gender.getCheckedRadioButtonId();
        radioSexButton=(RadioButton)findViewById(selectedId);
        if (!TextUtils.isEmpty(fname) && !TextUtils.isEmpty(lname) && !TextUtils.isEmpty(e_mail) && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(cpass) && pass.equals(cpass) && pass.length() >= 6) {


            doAuthentication(fname,lname,e_mail,pass,radioSexButton.getText(),phoneno);



        }
        else if (!pass.equals(cpass))
            Toast.makeText(this, "Password doesn't match!", Toast.LENGTH_LONG).show();
        else if (pass.length() < 6)
            Toast.makeText(this, "Password should be of atleast 6 characters", Toast.LENGTH_LONG).show();
        else if (TextUtils.isEmpty(fname))
            Toast.makeText(this, "Enter the First Name", Toast.LENGTH_LONG).show();
        else if (TextUtils.isEmpty(lname))
            Toast.makeText(this, "Enter the Last Name", Toast.LENGTH_LONG).show();
        else if (TextUtils.isEmpty(e_mail))
            Toast.makeText(this, "Enter an Email ID", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Can not register the User", Toast.LENGTH_LONG).show();


    }

    private void doAuthentication(String fname, String lname, String e_mail, String pass, CharSequence gender, String phoneno) {
        System.out.println(fname);
        System.out.println(lname);
        System.out.println(e_mail);
        System.out.println(pass);
        System.out.println(gender);
        System.out.println(phoneno);
        DatabaseReference databaseUserRegister=database.getReference();


      DatabaseReference child=databaseUserRegister.child(phoneno);

       DatabaseReference child1=child.child("First Name");
       child1.setValue(fname);

         child1=child.child("Last Name");
        child1.setValue(lname);

         child1=child.child("email");
        child1.setValue(e_mail);

         child1=child.child("Password");
        child1.setValue(pass);

         child1=child.child("Gender");
        child1.setValue(gender);

        child1=child.child("Phone");
        child1.setValue(phoneno);

    }


    @Override
    public void onBackPressed() {
        Intent i=new Intent(signupActivity.this,loginActivity.class);
        startActivity(i);
        finish();


    }
}
