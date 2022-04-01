/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import app.novacode.myservices.R;

public class SignUpSeller extends AppCompatActivity {

    Spinner selectCitySeller;
    EditText phoneSeller;
    EditText passwordSeller;
    EditText rePasswordSeller;
    TextView nextRegisterSeller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_seller);

        ArrayAdapter<CharSequence> adapterCountry =  ArrayAdapter.createFromResource(this, R.array.countrys, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);




    }
}