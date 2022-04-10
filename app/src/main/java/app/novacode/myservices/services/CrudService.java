/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.services;


import app.novacode.myservices.entity.Services;

public interface CrudService {

    public void createService(Services service);
    public void updateService(Services service);
    public void deleteService(int serviceCode);
    public Services getItem(int id);


}
