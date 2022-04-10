/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.repository;

import app.novacode.myservices.services.ClientService;

public abstract class UserRepository implements ClientService{

    private int usId;
    private String usFirsName;
    private String usSecondName;
    private String usCity;
    private String usEmail;
    private String usPhone;
    private String usPassword;
    private String usRol;


    @Override
    public String login(String mail, String password) {



        return null;
    }

    @Override
    public UserRepository signUp(UserRepository user) {
        return null;
    }

    @Override
    public String restorePassword(String email) {
        return null;
    }

    @Override
    public boolean isValidCode(String code) {
        return false;
    }

    @Override
    public void newPassword(String password) {

    }

    public int getUsId() {
        return usId;
    }

    public void setUsId(int usId) {
        this.usId = usId;
    }

    public String getUsFirsName() {
        return usFirsName;
    }

    public void setUsFirsName(String usFirsName) {
        this.usFirsName = usFirsName;
    }

    public String getUsSecondName() {
        return usSecondName;
    }

    public void setUsSecondName(String usSecondName) {
        this.usSecondName = usSecondName;
    }

    public String getUsCity() {
        return usCity;
    }

    public void setUsCity(String usCity) {
        this.usCity = usCity;
    }

    public String getUsEmail() {
        return usEmail;
    }

    public void setUsEmail(String usEmail) {
        this.usEmail = usEmail;
    }

    public String getUsPhone() {
        return usPhone;
    }

    public void setUsPhone(String usPhone) {
        this.usPhone = usPhone;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    public String getUsRol() {
        return usRol;
    }

    public void setUsRol(String usRol) {
        this.usRol = usRol;
    }
}
