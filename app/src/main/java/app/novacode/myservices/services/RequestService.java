/*
 * Copyright (c) $2019 NativeCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.services;

import android.content.Context;

import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

import app.novacode.myservices.repository.UserRepository;
import retrofit2.Call;
import retrofit2.http.POST;

public interface RequestService {


    void postData(Context context, Map<String,Object>  data, String route);
    Object getData(Object data);
    Object deleteData(Object id);
    Object putDate(Object data);


}
