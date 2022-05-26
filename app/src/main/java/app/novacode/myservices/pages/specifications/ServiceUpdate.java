/*
 * Copyright (c) $2019 NativeCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.specifications;

import androidx.appcompat.app.AppCompatActivity;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.R;
import app.novacode.myservices.entity.Services;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class ServiceUpdate extends AppCompatActivity {

    EditText nameService;
    EditText costService;
    EditText specData;

    Button updateService;
    ImageButton deleteButton;

    Services services = new Services();

    float price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_update);

        initialData();


        updateService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                services.setPriceService(Float.parseFloat(costService.getText().toString()));
                services.setIdService(getIntent().getExtras().getInt(ConstantValues.SERVICE_ID_KEY));
                services.setNameService(nameService.getText().toString());
                services.setSpecializationService(specData.getText().toString());
                services.setIdBusiness(getIntent().getExtras().getString(ConstantValues.BUSINESS_ID_KEY));
                services.setContactService(getIntent().getExtras().getString(ConstantValues.SERVICE_CONTACT_KEY));

                services.updateService(services, ServiceUpdate.this);

            }
        });



        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                services.deleteService( getIntent().getExtras().getInt(ConstantValues.SERVICE_ID_KEY), ServiceUpdate.this);
            }
        });

    }


    void initialData(){

        price = Float.parseFloat(String.valueOf(getIntent().getExtras().getFloat(ConstantValues.SERVICE_PRICE_KEY)));

        nameService = (EditText) findViewById(R.id.nameService);
        costService = (EditText) findViewById(R.id.costService);
        specData = (EditText) findViewById(R.id.specData);
        updateService = (Button) findViewById(R.id.updateService);
        deleteButton = (ImageButton) findViewById(R.id.deleteButton);

        nameService.setText(getIntent().getExtras().getString(ConstantValues.SERVICE_NAME_KEY));
        costService.setText(String.valueOf(price));
        specData.setText(getIntent().getExtras().getString(ConstantValues.SERVICE_ABOUT_KEY));
    }


}