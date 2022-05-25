/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.entity;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import app.novacode.myservices.adapter.GridAdapter;
import app.novacode.myservices.pages.dashboard.DashBoard;
import app.novacode.myservices.repository.BusinessRepository;
import app.novacode.myservices.services.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Rating {

    private int rateID;
    private String businessID;
    private float rate;
    private String mailRated;


    public Rating(String businessID, String mailRated) {

        this.businessID = businessID;
        this.mailRated = mailRated;
    }

    public int getRateID() {
        return rateID;
    }

    public void setRateID(int rateID) {
        this.rateID = rateID;
    }

    public String getBusinessID() {
        return businessID;
    }

    public void setBusinessID(String businessID) {
        this.businessID = businessID;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getMailRated() {
        return mailRated;
    }

    public void setMailRated(String mailRated) {
        this.mailRated = mailRated;
    }



}
