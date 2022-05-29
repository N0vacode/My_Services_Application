/*
 * Copyright (c) $2019 NativeCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.specifications;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.R;
import app.novacode.myservices.adapter.RecyclerViewAdapter;
import app.novacode.myservices.entity.Services;
import app.novacode.myservices.pages.dashboard.DashBoard;
import app.novacode.myservices.services.ApiService;
import app.novacode.myservices.widgets.AlertMsm;
import app.novacode.myservices.widgets.DialogType;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceInfo extends AppCompatActivity {

    FloatingActionButton backButton;
    Button ratingDialogButton;

    TextView aboutB;
    ImageView imageB;
    ImageView ratingB;
    TextView nameB;
    TextView websiteB;
    TextView phoneB;
    TextView mailB;
    TextView cityB;



    ArrayList<String> tittleService = new ArrayList<>();
    ArrayList<String> infoService = new ArrayList<>();
    ArrayList<Float> priceService = new ArrayList<>();


    RecyclerView recyclerView;
    LinearLayoutManager horizontalLayoutManager;
    String mail = "";

    private RecyclerViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_info);

        backButton = (FloatingActionButton) findViewById(R.id.backButton);
        ratingDialogButton = (Button) findViewById(R.id.ratingDialogButton);

        aboutB = (TextView) findViewById(R.id.aboutB);
        imageB = (ImageView) findViewById(R.id.imageB);
        ratingB = (ImageView) findViewById(R.id.ratingB);
        nameB = (TextView) findViewById(R.id.nameB);
        websiteB = (TextView) findViewById(R.id.websiteB);
        phoneB = (TextView) findViewById(R.id.phoneB);
        mailB = (TextView) findViewById(R.id.mailB);
        cityB = (TextView) findViewById(R.id.cityB);

        Intent backDashboard = new Intent(this, DashBoard.class);


        recyclerView = findViewById(R.id.myRecyclerView);
        horizontalLayoutManager = new LinearLayoutManager(ServiceInfo.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(backDashboard);

            }
        });



        ratingDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




//                //Send data to Rate Client
                AlertMsm newFragment = new AlertMsm("Rating",
                        "Add a rating for this seller of service, remember that this rating should be based on your experience using the service, attention and prices compared to quality.",
                        getIntent().getExtras().getString(ConstantValues.CLIENT_MAIL_KEY).toLowerCase(),
                        getIntent().getExtras().getString(ConstantValues.BUSINESS_ID_KEY));
                newFragment.setDialogType(DialogType.RATE);
                newFragment.show(getSupportFragmentManager(), "Rate Service");

               // confirmStartRating();
                //AlertMsm
            }
        });


        try {
            initializeBusinessData();


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    protected void initializeBusinessData() throws JSONException {


        String phoneNumber = getIntent().getExtras().getString(ConstantValues.USER_PHONE_KEY);
        String cityBusiness = getIntent().getExtras().getString(ConstantValues.USER_CITY_KEY);
        String website = getIntent().getExtras().getString(ConstantValues.BUSINESS_WEBSITE_KEY).toLowerCase();
        String businessId = getIntent().getExtras().getString(ConstantValues.BUSINESS_ID_KEY);
        String mailBusiness = getIntent().getExtras().getString(ConstantValues.USER_MAIL_KEY);

        initializeServicesdata(businessId);

        Glide.with(this)
                .load(getIntent().getExtras().getString(ConstantValues.BUSINESS_IMAGE_KEY))
                .into(imageB);

        aboutB.setText(getIntent().getExtras().getString(ConstantValues.BUSINESS_ABOUT_KEY));
        ratingB.setImageResource(ConstantValues.rateBusiness(getIntent().getExtras().getDouble(ConstantValues.BUSINESS_RATE_KEY)));
        nameB.setText(getIntent().getExtras().getString(ConstantValues.BUSINESS_NAME_KEY).toUpperCase());

        // CLick on Website link go to External Action website
        websiteB.setText(website);
        websiteB.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + website));

        websiteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent);

            }
        });

        phoneB.setText(phoneNumber);

        cityB.setText(cityBusiness);









    }



    protected void initializeServicesdata(String buinessId){



        Call<List<Services>> userRepositoryCall = ApiService.getUserService().getAllService(buinessId);

        userRepositoryCall.enqueue(new Callback<List<Services>>() {


            @Override
            public void onResponse(Call<List<Services>> call, Response<List<Services>> response) {

                try{




                    if(response.isSuccessful()){

                        String mailSeller = "";


                        for (int i = 0; i < response.body().size(); i++) {


                            tittleService.add(response.body().get(i).getNameService());
                            infoService.add(response.body().get(i).getSpecializationService());
                            priceService.add(response.body().get(i).getPriceService());
                            mailSeller = response.body().get(i).getContactService();
                        }


                        mailB.setText(mailSeller);

                        adapter = new RecyclerViewAdapter(ServiceInfo.this, tittleService, infoService, priceService);
                        recyclerView.setAdapter(adapter);

                    }


                }catch (Exception e){

                    System.out.println("Error: " + e.getMessage());
                    Toast.makeText(ServiceInfo.this, "This seller has not added services", Toast.LENGTH_SHORT).show();

                }



            }

            @Override
            public void onFailure(Call<List<Services>> call, Throwable t) {
                t.printStackTrace();}

        });



    }


}