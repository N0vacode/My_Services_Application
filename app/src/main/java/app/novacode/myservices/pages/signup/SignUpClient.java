/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import app.novacode.myservices.R;

public class SignUpClient extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner selectCityClient;
    EditText phoneClient;
    EditText passwordClient;
    EditText rePasswordClient;
    Button createAccountClient;

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



        createAccountClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO Create function for singup client
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        System.out.println(adapterView.getItemAtPosition(i));
        adapterView.getItemAtPosition(i);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}