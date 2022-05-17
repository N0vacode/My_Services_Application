/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.signup;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.R;
import app.novacode.myservices.adapter.Validation;
import app.novacode.myservices.entity.Client;
import app.novacode.myservices.services.MD5C;

public class SignUpClient extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner selectCityClient;
    EditText phoneClient;
    EditText passwordClient;
    EditText rePasswordClient;
    Button createAccountClient;


    Client clientData = new Client();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_client);

        ArrayAdapter<CharSequence> adapterCountry =  ArrayAdapter.createFromResource(this, R.array.countrys, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        createAccountClient = (Button) findViewById(R.id.createAccountClient);
        selectCityClient    = (Spinner) findViewById(R.id.selectCityClient);
        rePasswordClient    = (EditText) findViewById(R.id.rePasswordClient);
        passwordClient      = (EditText) findViewById(R.id.passwordClient);
        phoneClient         = (EditText) findViewById(R.id.phoneClient);

        selectCityClient.setAdapter(adapterCountry);
        selectCityClient.setOnItemSelectedListener(this);

        // Client previous layout data
        String userRol = getIntent().getExtras().getString(ConstantValues.USER_ROL_KEY);
        String userFirstName = getIntent().getExtras().getString("userFirstName");
        String userSecondName = getIntent().getExtras().getString("userSecondName");
        String userMail = getIntent().getExtras().getString("userMail");






        createAccountClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MD5C.setUserData(rePasswordClient.getText().toString());
                String passMd5 = MD5C.convert();
                clientData.setUsRol(userRol);
                clientData.setUsFirsName(userFirstName);
                clientData.setUsSecondName(userSecondName);
                clientData.setUsEmail(userMail);


                if(Validation.data(passwordClient,"Enter your Password","password")){

                    if(passwordClient.getText().toString().equals(rePasswordClient.getText().toString())){


                        clientData.setUsPhone(phoneClient.getText().toString());
                        clientData.setUsPassword(passMd5);


                        // Here is for create client account, and validation data.
                        if(!clientData.getUsCity().isEmpty()) {

                            clientData.signUpUser(SignUpClient.this, clientData);
                          //  clientData.getUser(SignUpClient.this,11);

                        }


                    }else{

                        Toast.makeText(SignUpClient.this, "Second password is diferent to First Password", Toast.LENGTH_SHORT).show();

                    }
                }


                //TODO Create function for singup client
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        System.out.println(adapterView.getItemAtPosition(i).toString());

        clientData.setUsCity(adapterView.getItemAtPosition(i).toString());
        System.out.println( adapterView.getItemAtPosition(i).toString() );
        adapterView.getItemAtPosition(i);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}