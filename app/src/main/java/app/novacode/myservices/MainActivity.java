/*
 * Copyright (c) 2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import app.novacode.myservices.adapter.Validation;
import app.novacode.myservices.pages.recovery.PasswordRecovery;
import app.novacode.myservices.pages.signup.SignUp;
import app.novacode.myservices.pages.signup.SignUpSellerBusiness;
import app.novacode.myservices.services.Login;
import app.novacode.myservices.services.MD5C;

public class MainActivity extends AppCompatActivity {

    TextView signUp;
    TextView passwordRecover;
    EditText emailLogin;
    EditText passwordLogin;
    Button loginButton;
    CheckBox saveSesion;

    String msmChangedActivity;

    SharedPreferences userPreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        userPreferences = this.getPreferences(Context.MODE_PRIVATE);
        editor = userPreferences.edit();

        // Declaration of Attributes
        signUp = (TextView) findViewById(R.id.signUp);
        passwordRecover = (TextView) findViewById(R.id.passwordRecover);
        loginButton     = (Button)   findViewById(R.id.loginButton);
        saveSesion      = (CheckBox) findViewById(R.id.saveSesion);

        passwordLogin   = (EditText) findViewById(R.id.passwordLogin);
        passwordLogin.setInputType(129);

        emailLogin      = (EditText) findViewById(R.id.emailLogin);
        emailLogin.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);


        Intent signUpIntent = new Intent(this, SignUp.class);
        Intent passwordRecoveryIntent = new Intent(this, PasswordRecovery.class);




        if( haveSavedData() ) {

            // TODO: Create a circular Prgress Indicator
            Login.user(MainActivity.this, userPreferences.getString(ConstantValues.USER_MAIL_KEY, ConstantValues.USER_MAIL_KEY),
                    userPreferences.getString(ConstantValues.USER_PASS_KEY, ConstantValues.USER_PASS_KEY));
        }


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

                MD5C.setUserData(passwordLogin.getText().toString());
                String passMd5 = MD5C.convert();

                    if (Validation.data(emailLogin, "You must enter an email", "mail"))
                        if (Validation.data(passwordLogin, "You must enter an password", "password")) {

                            if(saveSesion.isChecked()) {

                                saveLoginData(emailLogin.getText().toString(), passMd5);
                            }
                            Login.user(MainActivity.this,
                                    emailLogin.getText().toString(),
                                    passMd5);
                        }

            }
        });


    }



    protected void saveLoginData(String mailData, String password){

        editor.putString(ConstantValues.USER_MAIL_KEY, mailData).apply();
        editor.putString(ConstantValues.USER_PASS_KEY, password).apply();
        editor.putBoolean(ConstantValues.SAVED_DATA_USER, true).apply();

    }


    protected boolean haveSavedData(){

        return this.userPreferences.getBoolean(ConstantValues.SAVED_DATA_USER, false);
    }

}