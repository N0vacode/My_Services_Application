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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_edit);


        backButton2 = (FloatingActionButton) findViewById(R.id.backButton2);
        servicesListSeller = (ListView) findViewById(R.id.servicesListSeller);






        Intent backHome = new Intent(this, DashBoard.class);

        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(backHome);
            }
        });


        servicesListSeller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(ServiceList.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(ServiceList.this, "Index: " + idAService.get(i), Toast.LENGTH_LONG).show();


            }
        });

        initializeServicesdata(getIntent().getExtras().getString(ConstantValues.BUSINESS_ID_KEY));


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


//                            tittleService.add(response.body().get(i).getNameService());
//                            infoService.add(response.body().get(i).getSpecializationService());
//                            priceService.add(response.body().get(i).getPriceService());
                        }


                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ServiceList.this,android.R.layout.simple_list_item_1, arrayList);
                        servicesListSeller.setAdapter(arrayAdapter);

//
//                        adapter = new RecyclerViewAdapter(ServiceInfo.this, tittleService, infoService, priceService);
//                        recyclerView.setAdapter(adapter);

                    }


                }catch (Exception e){

                    System.out.println("Error: " + e.getMessage());
                   // Toast.makeText(ServiceInfo.this, "This seller has not added services", Toast.LENGTH_SHORT).show();

                }



            }

            @Override
            public void onFailure(Call<List<Services>> call, Throwable t) {
                t.printStackTrace();}

        });





    }





}