/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.services;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.repository.UserRepository;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    static String responseOkHttp;

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantValues.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        System.out.println(okHttpClient.getRouteDatabase() + " @@@@@@@@@@@@@@@");


        return retrofit;


    }


    //Return User services by retrofit POST, GET, PUT, DELETE Method using OkHttp for build, and convert data Gson
    public static UserService getUserService(){

        return getRetrofit().create(UserService.class);

    }


}
