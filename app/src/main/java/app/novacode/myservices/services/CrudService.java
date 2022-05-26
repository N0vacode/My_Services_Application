/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.services;


import android.content.Context;

import app.novacode.myservices.entity.Services;

public interface CrudService {

    public void createService(Services service, Context context);
    public void updateService(Services service, Context context);
    public void deleteService(int serviceCode, Context context);


}
