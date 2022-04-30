/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.repository;

import app.novacode.myservices.services.CrudService;

public abstract class BusinessRepository extends UserRepository{

    private String Bid;
    private String bArea;
    private String bName;
    private String bMail;
    private String bWebsite;
    private String bAbout;
    private String bImageUrl;


    public String getBid() {
        return Bid;
    }

    public void setBid(String bid) {
        Bid = bid;
    }

    public String getbArea() {
        return bArea;
    }

    public void setbArea(String bArea) {
        this.bArea = bArea;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbMail() {
        return bMail;
    }

    public void setbMail(String bMail) {
        this.bMail = bMail;
    }

    public String getbWebsite() {
        return bWebsite;
    }

    public void setbWebsite(String bWebsite) {
        this.bWebsite = bWebsite;
    }

    public String getbAbout() {
        return bAbout;
    }

    public void setbAbout(String bAbout) {
        this.bAbout = bAbout;
    }

    public String getbImageUrl() {
        return bImageUrl;
    }

    public void setbImageUrl(String bImageUrl) {
        this.bImageUrl = bImageUrl;
    }
}
