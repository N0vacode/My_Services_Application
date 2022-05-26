/*
 * Copyright (c) $2019 NativeCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.controller;

import android.content.Context;

import java.io.IOException;
import java.util.Map;

import app.novacode.myservices.services.RequestService;
import retrofit2.http.GET;

public class RequestController implements RequestService {


    private final String link = "http://172.245.226.231:8080/myservice/api/v1";

    @Override
    public void postData(Context context,Map<String,Object> params, String route){


    }


    @Override
    public Object getData(Object data) {
        return null;
    }

    @Override
    public Object deleteData(Object id) {
        return null;
    }

    @Override
    public Object putDate(Object data) {
        return null;
    }



}
