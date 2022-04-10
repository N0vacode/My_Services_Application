/*
 * Copyright (c) 2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.novacode.myservices.adapter.Validation;
import app.novacode.myservices.pages.dashboard.DashBoard;
import app.novacode.myservices.pages.recovery.PasswordRecovery;
import app.novacode.myservices.pages.signup.SignUp;

public class MainActivity extends AppCompatActivity {

    TextView signUp;
    TextView passwordRecover;
    EditText emailLogin;
    EditText passwordLogin;
    Button loginButton;


    String msmChangedActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Declaration of Attributes
        signUp = (TextView) findViewById(R.id.signUp);
        passwordRecover = (TextView) findViewById(R.id.passwordRecover);
        loginButton     = (Button)   findViewById(R.id.loginButton);

        passwordLogin   = (EditText) findViewById(R.id.passwordLogin);
        passwordLogin.setInputType(129);

        emailLogin      = (EditText) findViewById(R.id.emailLogin);
        emailLogin.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);



        Intent signUpIntent = new Intent(this, SignUp.class);
        Intent passwordRecoveryIntent = new Intent(this, PasswordRecovery.class);
        Intent dashboard = new Intent(this, DashBoard.class);


        // Sign Up Cliente or Seller Activity
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msmChangedActivity = "Please Insert Data";
                Toast.makeText(MainActivity.this,msmChangedActivity,Toast.LENGTH_LONG).show();
                startActivity(signUpIntent);

            }
        });


        // Go to recovery pass
        passwordRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msmChangedActivity = "Please Inser your Mail";
                Toast.makeText(MainActivity.this,msmChangedActivity,Toast.LENGTH_LONG).show();
                startActivity(passwordRecoveryIntent);
            }
        });

        // Login Client or Seller
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Validation.data(emailLogin, "You must enter an email", "mail"))
                    if(Validation.data(passwordLogin, "You must enter an password","password"))
                        Toast.makeText(MainActivity.this,"Loguin Susses", Toast.LENGTH_LONG).show();


//                startActivity(dashboard);
            }
        });


    }


}