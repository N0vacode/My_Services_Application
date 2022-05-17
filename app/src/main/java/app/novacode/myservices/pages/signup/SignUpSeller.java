/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.R;
import app.novacode.myservices.entity.Client;
import app.novacode.myservices.entity.Seller;

public class SignUpSeller extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner selectCityClient;
    EditText phoneSeller;
    EditText passwordSeller;
    EditText rePasswordSeller;
    TextView nextRegisterSeller;
    Seller sellerData = new Seller();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_seller);

        ArrayAdapter<CharSequence> adapterCountry =  ArrayAdapter.createFromResource(this, R.array.countrys, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        selectCityClient    = (Spinner) findViewById(R.id.selectCitySeller);
        nextRegisterSeller  = (TextView) findViewById(R.id.nextRegisterSeller);
        rePasswordSeller    = (EditText) findViewById(R.id.rePasswordSeller);
        phoneSeller         = (EditText) findViewById(R.id.phoneSeller);
        passwordSeller      = (EditText) findViewById(R.id.passwordSeller);


        selectCityClient.setAdapter(adapterCountry);
        selectCityClient.setOnItemSelectedListener(this);


        Intent bussinessRegister = new Intent(this,SignUpSellerBusiness.class);




        nextRegisterSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                bussinessRegister.putExtra(ConstantValues.USER_CITY_KEY, sellerData.getUsCity());
                bussinessRegister.putExtra(ConstantValues.USER_PASS_KEY, sellerData.getUsPassword());
                bussinessRegister.putExtra(ConstantValues.USER_PHONE_KEY, sellerData.getUsPhone());

                bussinessRegister.putExtra(ConstantValues.USER_FNAME_KEY,getIntent().getStringExtra(ConstantValues.USER_FNAME_KEY));
                bussinessRegister.putExtra(ConstantValues.USER_SNAME_KEY,getIntent().getStringExtra(ConstantValues.USER_SNAME_KEY));
                bussinessRegister.putExtra(ConstantValues.USER_MAIL_KEY,getIntent().getStringExtra(ConstantValues.USER_MAIL_KEY));
                bussinessRegister.putExtra(ConstantValues.USER_ROL_KEY,getIntent().getStringExtra(ConstantValues.USER_ROL_KEY));

                startActivity(bussinessRegister);


            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        System.out.println(adapterView.getItemAtPosition(i).toString());

        sellerData.setUsCity(adapterView.getItemAtPosition(i).toString());
        System.out.println( adapterView.getItemAtPosition(i).toString() );
        adapterView.getItemAtPosition(i);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}