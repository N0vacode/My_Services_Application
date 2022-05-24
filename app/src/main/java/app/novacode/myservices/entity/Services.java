/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.entity;

import android.content.Context;
import android.widget.Toast;

import app.novacode.myservices.R;
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
                System.out.println(t + " Services 89");
//                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });


    }

    @Override
    public void updateService(Services service) {


    }

    @Override
    public void deleteService(int serviceCode) {


    }



    public static Services[] ITEMS = {
            new Services("Jaguar F-Type 2015", R.drawable.ic_art),
            new Services("Mercedes AMG-GT", R.drawable.ic_services),
            new Services("Mazda MX-5", R.drawable.ic_building),
            new Services("Porsche 911 GTS", R.drawable.ic_electrical),
            new Services("BMW Serie 6", R.drawable.ic_carpenter),
            new Services("Ford Mondeo", R.drawable.ic_healt),
    };

    @Override
    public Services getItem(int id) {
        for (Services item : ITEMS) {
            if (item.getIdService() == id) {
                return item;
            }
        }
        return null;
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

    public static Services[] getITEMS() {
        return ITEMS;
    }

    public static void setITEMS(Services[] ITEMS) {
        Services.ITEMS = ITEMS;
    }
}
