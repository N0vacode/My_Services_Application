/*
 * Copyright (c) $2019 NativeCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.R;
import app.novacode.myservices.adapter.GridAdapter;
//import app.novacode.myservices.databinding.ActivityMainBinding;
import app.novacode.myservices.pages.specifications.ServiceList;
import app.novacode.myservices.pages.specifications.ServiceInfo;
import app.novacode.myservices.pages.specifications.ServiceUpdate;
import app.novacode.myservices.repository.BusinessRepository;
import app.novacode.myservices.services.ApiService;
import app.novacode.myservices.widgets.CreateServiceDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar app_bar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    GridView servicesList;
    EditText search;
    FloatingActionButton searchData;
    GridAdapter gridAdapter;



    SharedPreferences userPreferences;
    SharedPreferences.Editor editor;


    ArrayList<Double> rate =  new ArrayList<Double>();
    ArrayList<String> image = new ArrayList<String>();
    ArrayList<String> codeService = new ArrayList<String>();
    ArrayList<String> serviceName = new ArrayList<String>();
    ArrayList<String> aboutB = new ArrayList<String>();
    ArrayList<String> websiteB = new ArrayList<String>();
    ArrayList<String> phoneB = new ArrayList<String>();
    ArrayList<String> myMail = new ArrayList<String>();
    ArrayList<String> cityB = new ArrayList<String>();

    String myBID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        userPreferences = this.getPreferences(Context.MODE_PRIVATE);
        editor = userPreferences.edit();

        navigationView = (NavigationView) findViewById(R.id.navigationView);
        app_bar = (Toolbar) findViewById(R.id.appBar);
        app_bar.setTitle("");
        app_bar.setSubtitle("");

        search = (EditText) findViewById(R.id.search);
        searchData = (FloatingActionButton) findViewById(R.id.searchData);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        servicesList = (GridView) findViewById(R.id.servicesList); // GridView


        // Start Import Data Sellers
        navigationView.setFitsSystemWindows(true);
        navigationView.setNavigationItemSelectedListener(this);

        setSupportActionBar(app_bar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, app_bar, R.string.open, R.string.close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        Intent myServicesList = new Intent(this, ServiceInfo.class);
        servicesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String userMail = userPreferences.getString(ConstantValues.USER_MAIL_KEY, ConstantValues.USER_MAIL_KEY);

                view.setSelected(true);
                final String idBusiness = codeService.get(i);
                final double rateBusiness = rate.get(i);
                final String nameBusiness = serviceName.get(i);
                final String imageBusiness = image.get(i);
                final String aboutBusiness = aboutB.get(i);
                final String websiteBusiness = websiteB.get(i);

                myServicesList.putExtra(ConstantValues.BUSINESS_ID_KEY, idBusiness);
                myServicesList.putExtra(ConstantValues.BUSINESS_RATE_KEY, rateBusiness);
                myServicesList.putExtra(ConstantValues.BUSINESS_NAME_KEY, nameBusiness);
                myServicesList.putExtra(ConstantValues.BUSINESS_IMAGE_KEY, imageBusiness);
                myServicesList.putExtra(ConstantValues.BUSINESS_ABOUT_KEY, aboutBusiness);
                myServicesList.putExtra(ConstantValues.BUSINESS_WEBSITE_KEY, websiteBusiness);
                myServicesList.putExtra(ConstantValues.USER_PHONE_KEY,phoneB.get(i));
                myServicesList.putExtra(ConstantValues.USER_MAIL_KEY, myMail.get(i));
                myServicesList.putExtra(ConstantValues.USER_CITY_KEY, cityB.get(i));
                myServicesList.putExtra(ConstantValues.CLIENT_MAIL_KEY, userMail);

                startActivity(myServicesList);

            }


        });


        // Validation if is Seller or Client
        if( haveSavedData() ) {

            if(userPreferences.getString(ConstantValues.USER_ROL_KEY,"Client").equals("Client")) {
                navigationView.getMenu().findItem(R.id.services).setVisible(false);
            }

            Toast.makeText(this, userPreferences.getString(ConstantValues.USER_FNAME_KEY,"Client"), Toast.LENGTH_SHORT).show();

        }else{

            saveLoginData();

            if(getIntent().getStringExtra(ConstantValues.USER_ROL_KEY).equals("Client")) {
                navigationView.getMenu().findItem(R.id.services).setVisible(false);
            }
            Toast.makeText(this, userPreferences.getString(ConstantValues.USER_FNAME_KEY,"Client"), Toast.LENGTH_SHORT).show();
        }

        getBusiness("all",null);




        searchData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Cleanin Values
                cleanData();

                getBusiness("id", search.getText().toString() );

            }

        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Intent myServicesList = new Intent(DashBoard.this, ServiceList.class);
        myServicesList.putExtra(ConstantValues.BUSINESS_ID_KEY, myBID);
        myServicesList.putExtra(ConstantValues.USER_MAIL_KEY, getIntent().getStringExtra(ConstantValues.USER_MAIL_KEY));

        switch(item.getItemId()){

            case R.id.carpentry:
                filterByMenu(R.string.carpentry);
                break;
            case R.id.plumbing:
                filterByMenu(R.string.plumbing);
                break;
            case R.id.electricity:
                filterByMenu(R.string.electricity);
                break;
            case R.id.electronics:
                filterByMenu(R.string.electronics);
                break;
            case R.id.bodywork:
                filterByMenu(R.string.bodywork);
                break;
            case R.id.building:
                filterByMenu(R.string.building);
                break;
            case R.id.mechanics:
                filterByMenu(R.string.mechanics);
                break;
            case R.id.technology:
                filterByMenu(R.string.technology);
            case R.id.health:
                filterByMenu(R.string.health);
                break;
            case R.id.fashion:
                filterByMenu(R.string.fashion);
                break;
            case R.id.other:
                filterByMenu(R.string.others);
                break;
            case R.id.newService:
                createNewService();
                break;
            case R.id.myServices:
                startActivity(myServicesList);
                break;

        }

        return false;

    }


    public void createNewService() {


        int codeUser = Integer.parseInt(userPreferences.getString(ConstantValues.USER_ID_KEY, "0"));
        String contact = userPreferences.getString(ConstantValues.USER_MAIL_KEY, "info@novacode.app");

        DialogFragment newFragment = new CreateServiceDialog(codeUser, contact);


        newFragment.show(getSupportFragmentManager(), "New Service");


    }


    protected boolean haveSavedData(){
        return this.userPreferences.getBoolean(ConstantValues.SAVED_DATA_USER, false);
    }

    protected void saveLoginData(){

        editor.putString(ConstantValues.USER_MAIL_KEY, getIntent().getStringExtra(ConstantValues.USER_MAIL_KEY)).apply();
        editor.putString(ConstantValues.USER_ROL_KEY, getIntent().getStringExtra(ConstantValues.USER_ROL_KEY)).apply();
        editor.putString(ConstantValues.USER_FNAME_KEY, getIntent().getStringExtra(ConstantValues.USER_FNAME_KEY)).apply();
        editor.putString(ConstantValues.USER_ID_KEY, getIntent().getStringExtra(ConstantValues.USER_ID_KEY)).apply();
        editor.putBoolean(ConstantValues.SAVED_DATA_USER, true).apply();

    }

    private void getBusiness(String type, String name){

        serviceName.clear();
        image.clear();
        rate.clear();

        Call<List<BusinessRepository>> userRepositoryCall = null;

        if( !type.equals("t") ) {

            if (search.getText().toString().isEmpty() && type.equals("all")) {

                userRepositoryCall = ApiService.getUserService().getBusinessData();

            } else if (type.equals("id")) {
                userRepositoryCall = ApiService.getUserService().getBusinessDataByName(name);

            }
        }else{

                userRepositoryCall = ApiService.getUserService().getBusinessDataByArea(name);

        }

        assert userRepositoryCall != null;
        userRepositoryCall.enqueue(new Callback<List<BusinessRepository>>() {


            @Override
            public void onResponse(Call<List<BusinessRepository>> call, Response<List<BusinessRepository>> response) {

                try{



                    if(response.isSuccessful()){





                        for (int i = 0; i < response.body().size(); i++) {


                            image.add(response.body().get(i).getImageUrl());
                            serviceName.add(response.body().get(i).getBusinessName());
                            rate.add(response.body().get(i).getRate());
                            codeService.add(response.body().get(i).getBusinessId());
                            aboutB.add(response.body().get(i).getBusinessAbout());
                            websiteB.add(response.body().get(i).getBusinessWebsite());
                            phoneB.add(String.valueOf(response.body().get(i).getSellerData().get("usPhone")));
                            myMail.add(String.valueOf(response.body().get(i).getSellerData().get("usMail")));
                            cityB.add(String.valueOf(response.body().get(i).getSellerData().get("usCity")));


                            if(Integer.parseInt(String.valueOf(response.body().get(i).getSellerId())) ==  Integer.parseInt(userPreferences.getString(ConstantValues.USER_ID_KEY, ConstantValues.USER_ID_KEY))){
                                myBID = response.body().get(i).getBusinessId();

                                editor.putString(ConstantValues.BUSINESS_ID_KEY, response.body().get(i).getBusinessId());
                            }



                        }



                        gridAdapter = new GridAdapter(DashBoard.this,serviceName,image, rate);
                        servicesList.setAdapter(gridAdapter);

//                        gridAdapter = new GridAdapter();
//                        servicesList.setAdapter(gridAdapter);



                    }


                }catch (Exception e){

                    System.out.println("Error: " + e.getMessage());

                }



            }

            @Override
            public void onFailure(Call<List<BusinessRepository>> call, Throwable t) {
                t.printStackTrace();
                System.out.println(t + " On Failure Dashboard 276");
            }

        });






    }



    protected void cleanData(){
        serviceName.clear();
        image.clear();
        rate.clear();
    }


    protected void filterByMenu(int value){

        serviceName.clear();
        image.clear();
        rate.clear();


        getBusiness("t", DashBoard.this.getString(value));
    }

}

