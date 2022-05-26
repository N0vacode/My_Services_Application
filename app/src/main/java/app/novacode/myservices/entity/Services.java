/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.entity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import app.novacode.myservices.R;
import app.novacode.myservices.pages.dashboard.DashBoard;
import app.novacode.myservices.pages.specifications.ServiceList;
import app.novacode.myservices.repository.BusinessRepository;
import app.novacode.myservices.services.ApiService;
import app.novacode.myservices.services.CrudService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Services implements CrudService {

    private int idService;
    private String idBusiness;
    private String nameService;
    private String specializationService;
    private float priceService;
    private String contactService;

    private int idDrawable;
    private boolean dones = false;

    //---------------------------------
    //Conductor Overload

    /**
     * Initial COnstructor for new Services
     * **/
    public Services(String name, BusinessRepository businessRepository, String specifications, float price, String constrac){

        this.nameService = name;
        this.idBusiness = businessRepository.getBusinessId();
        this.specializationService = specifications;
        this.priceService = price;
        this.contactService = constrac;


    }


    /**
     * Constructor for calll each services on Dashboard
     * **/
    public Services(String name, int idDrawable) {
        this.nameService = name;
        this.idDrawable = idDrawable;
    }

    /**
     * Constructor for Instanciation
     * **/
    public  Services(){}

    //---------------------------------




    @Override
    public void createService(Services service, Context context) {


        Call<Services> userRepositoryCall = ApiService.getUserService().saveServices(service);

        userRepositoryCall.enqueue(new Callback<Services>() {

            @Override
            public void onResponse(Call<Services> call, Response<Services> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(context, "Done!!", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(context, "Could Not Create Service", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Services> call, Throwable t) {
                System.out.println(t);
//                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });


    }

    @Override
    public void updateService(Services service, Context context) {

        Intent servicesList = new Intent(context, DashBoard.class);

        Call<Services> userRepositoryCall = ApiService.getUserService().updateService(service);

        userRepositoryCall.enqueue(new Callback<Services>() {

            @Override
            public void onResponse(@NonNull Call<Services> call, @NonNull Response<Services> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(context, "Done!!", Toast.LENGTH_SHORT).show();
                    context.startActivity(servicesList);
                }else{
                    Toast.makeText(context, "Could Not Create Service", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Services> call, Throwable t) {
                System.out.println(t);
//                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });


    }

    @Override
    public void deleteService(int serviceCode, Context context) {



        Intent servicesList = new Intent(context, DashBoard.class);

        Call<Boolean> userRepositoryCall = ApiService.getUserService().deleteService(1);

        userRepositoryCall.enqueue(new Callback<Boolean>() {

            @Override
            public void onResponse(@NonNull Call<Boolean> call, @NonNull Response<Boolean> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(context, "Done!!", Toast.LENGTH_SHORT).show();
                    context.startActivity(servicesList);
                }else{
                    Toast.makeText(context, "Could Not Delete Service", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable t) {
                System.out.println(t);
//                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });




    }




    public int getIdDrawable() {
        return idDrawable;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(String idBusiness) {
        this.idBusiness = idBusiness;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getSpecializationService() {
        return specializationService;
    }

    public void setSpecializationService(String specializationService) {
        this.specializationService = specializationService;
    }

    public float getPriceService() {
        return priceService;
    }

    public void setPriceService(float priceService) {
        this.priceService = priceService;
    }

    public String getContactService() {
        return contactService;
    }

    public void setContactService(String contactService) {
        this.contactService = contactService;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

}
