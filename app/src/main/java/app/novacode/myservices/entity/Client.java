/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.entity;


import app.novacode.myservices.repository.UserRepository;

public class Client extends UserRepository {

    private double rate;

    public Client(
            double rate,
            int userId,
            String firtsName,
            String secondName,
            String cityUser,
            String mail,
            String phone,
            String password,
            String rol) {
        this.setUsId(userId);
        this.rate = rate;
        this.setUsFirsName(firtsName);
        this.setUsSecondName(secondName);
        this.setUsCity(cityUser);
        this.setUsEmail(mail);
        this.setUsPhone(phone);
        this.setUsPassword(password);
        this.setUsRol(rol);
    }

    public Client(){}

    void sendRate(){}

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
