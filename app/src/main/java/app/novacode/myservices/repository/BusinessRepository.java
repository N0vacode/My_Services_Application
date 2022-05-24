/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.repository;


import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

public class BusinessRepository {

    private Integer sellerId;
    private String businessId;
    private String businessArea;
    private String businessName;
    private String businessWebsite;
    private String businessAbout;
    private String imageUrl;
    private byte[] imageByte;
    private double rate;
    JSONObject sellerData;


    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessWebsite() {
        return businessWebsite;
    }

    public void setBusinessWebsite(String businessWebsite) {
        this.businessWebsite = businessWebsite;
    }

    public String getBusinessAbout() {
        return businessAbout;
    }

    public void setBusinessAbout(String businessAbout) {
        this.businessAbout = businessAbout;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }


    public byte[] getImageByte() {
        return imageByte;
    }

    public void setImageByte(byte[] imageByte) {
        this.imageByte = imageByte;
    }

    public JSONObject getSellerData() {
        return sellerData;
    }

    public void setSellerData(JSONObject sellerData) {
        this.sellerData = sellerData;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
