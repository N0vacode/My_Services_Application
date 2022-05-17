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
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import app.novacode.myservices.R;

public class SignUpSellerBusiness extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner categoryService;
    EditText bsName;
    EditText bsWebsite;
    EditText bsAbout;
    ImageView uploadBusinessImage;
    Button bsCreate;
    String categoryBussiness;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_seller_business);
        ArrayAdapter<CharSequence> adapterRol =  ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        adapterRol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        uploadBusinessImage = (ImageView) findViewById(R.id.uploadBusinessImage);
        categoryService     = (Spinner) findViewById(R.id.categoryService);
        bsWebsite = (EditText)  findViewById(R.id.bsWebsite);
        bsCreate  = (Button) findViewById(R.id.bsCreate);
        bsAbout   = (EditText) findViewById(R.id.bsAbout);
        bsName    = (EditText) findViewById(R.id.bsName);


        categoryService.setAdapter(adapterRol);
        categoryService.setOnItemSelectedListener(this);



        //TODO: CREATE A IMPORT DATA, UPLOAD IMAGE, REGISTER USER AND BUSSINESS
        // TODO; MODIFY BACKEND FOR REGISTER SELLER AND BUSINESS
        bsCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        parent.getItemAtPosition(position);

        categoryBussiness = parent.getItemAtPosition(position).toString();

        System.out.println(categoryBussiness);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}