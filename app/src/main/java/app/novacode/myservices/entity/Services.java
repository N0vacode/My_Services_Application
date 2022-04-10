/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.entity;

import app.novacode.myservices.R;
import app.novacode.myservices.services.CrudService;

public class Services implements CrudService {
    private int sId;
    private String businessId;
    private String sName;
    private String sSpecifications;
    private float sPrice;
    private String sContract;

    private int idDrawable;


    //---------------------------------
    //Conductor Overload

    /**
     * Initial COnstructor for new Services
     * **/
    public Services(String name, Seller seller, String specifications, float price, String constrac){

        this.sName = name;
        this.businessId = seller.getBid();
        this.sSpecifications = specifications;
        this.sPrice = price;
        this.sContract = constrac;


    }


    /**
     * COnstructor for calll each services on dashboar
     * **/
    public Services(String name, int idDrawable) {
        this.sName = name;
        this.idDrawable = idDrawable;
    }

    /**
     * Constructor for Instanciation
     * **/
    public  Services(){}

    //---------------------------------




    @Override
    public void createService(Services service) {


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
            if (item.getsId() == id) {
                return item;
            }
        }
        return null;
    }





    public int getIdDrawable() {
        return idDrawable;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSpecifications() {
        return sSpecifications;
    }

    public void setsSpecifications(String sSpecifications) {
        this.sSpecifications = sSpecifications;
    }

    public float getsPrice() {
        return sPrice;
    }

    public void setsPrice(float sPrice) {
        this.sPrice = sPrice;
    }

    public String getsContract() {
        return sContract;
    }

    public void setsContract(String sContract) {
        this.sContract = sContract;
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
