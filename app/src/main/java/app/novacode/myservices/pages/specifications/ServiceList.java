/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.specifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.R;
import app.novacode.myservices.entity.Services;
import app.novacode.myservices.pages.dashboard.DashBoard;
import app.novacode.myservices.services.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceList extends AppCompatActivity {

    FloatingActionButton backButton2 ;
    ListView servicesListSeller;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<Integer> idAService = new ArrayList<>();
    ArrayList<Float> price = new ArrayList<>();
    ArrayList<String> specifications = new ArrayList<>();
    ArrayList<String> contactService = new ArrayList<>();
    ArrayList<String> nameService = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_edit);


        backButton2 = (FloatingActionButton) findViewById(R.id.backButton2);
        servicesListSeller = (ListView) findViewById(R.id.servicesListSeller);


        Intent backHome = new Intent(this, DashBoard.class);
        Intent updateService = new Intent(this, ServiceUpdate.class);

        initializeServicesdata(getIntent().getExtras().getString(ConstantValues.BUSINESS_ID_KEY));


        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(backHome);
            }
        });


        servicesListSeller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                updateService.putExtra(ConstantValues.SERVICE_ID_KEY, idAService.get(i));
                updateService.putExtra(ConstantValues.BUSINESS_ID_KEY, getIntent().getExtras().getString(ConstantValues.BUSINESS_ID_KEY));
                updateService.putExtra(ConstantValues.SERVICE_ABOUT_KEY, specifications.get(i));
                updateService.putExtra(ConstantValues.SERVICE_CONTACT_KEY, contactService.get(i));
                updateService.putExtra(ConstantValues.SERVICE_NAME_KEY, nameService.get(i));
                updateService.putExtra(ConstantValues.SERVICE_PRICE_KEY, price.get(i));


                startActivity(updateService);

            }
        });


    }

    protected void initializeServicesdata(String buinessId){

        Call<List<Services>> userRepositoryCall = ApiService.getUserService().getAllService(buinessId);

        userRepositoryCall.enqueue(new Callback<List<Services>>() {


            @Override
            public void onResponse(Call<List<Services>> call, Response<List<Services>> response) {

                try{

                    if(response.isSuccessful()){



                        for (int i = 0; i < response.body().size(); i++) {


                            arrayList.add(response.body().get(i).getNameService().toString());
                            idAService.add(response.body().get(i).getIdService());
                            price.add(response.body().get(i).getPriceService());
                            specifications.add(response.body().get(i).getSpecializationService());
                            contactService.add(response.body().get(i).getContactService());
                            nameService.add(response.body().get(i).getNameService());

                        }


                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ServiceList.this,android.R.layout.simple_list_item_1, arrayList);
                        servicesListSeller.setAdapter(arrayAdapter);

                    }


                }catch (Exception e){

                    System.out.println("Error: " + e.getMessage());

                }



            }

            @Override
            public void onFailure(Call<List<Services>> call, Throwable t) {
                t.printStackTrace();}

        });





    }





}