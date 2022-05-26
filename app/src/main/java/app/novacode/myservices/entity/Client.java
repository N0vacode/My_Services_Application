/*
 * Copyright (c) $2019 NativeCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.entity;


import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.controller.RequestController;
import app.novacode.myservices.repository.UserRepository;
import app.novacode.myservices.services.ApiService;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Client extends UserRepository {



    public Client(){}
    

    void print(Object obj){
        System.out.println(obj);
    }
}
