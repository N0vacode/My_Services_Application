/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.services;


import java.util.Map;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.repository.UserRepository;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST(ConstantValues.PATH_SIGNUP_CLIENT)
    Call<UserRepository> creteAccount(@Body Object userRepository);

    @GET(ConstantValues.PATH_GET_EMAIL)
    Call<UserRepository> getAccountData(@Path("mail") String email);

    @GET(ConstantValues.PATH_EXIST_MAIL)
    Call<Map<String, Boolean>> emailExist(@Path("mail") String mail);



}
