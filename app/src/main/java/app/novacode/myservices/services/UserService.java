/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.services;


import java.util.Map;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.entity.CodesValidator;
import app.novacode.myservices.pages.recovery.CodeValidator;
import app.novacode.myservices.repository.UserRepository;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @POST(ConstantValues.PATH_SIGNUP_CLIENT)
    Call<UserRepository> creteAccount(@Body Object userRepository);

    @POST(ConstantValues.PATH_SEND_CODE)
    Call<Map<String, String>> sendCodeToRecoveryPassword(@Body Object mailToRecovery);


    @PUT(ConstantValues.PATH_SEND_CODE)
    Call<CodesValidator> sendPutCode(@Body CodesValidator codesValidator);

    @PUT(ConstantValues.PATH_USER_MAIN)
    Call<Map<String, Object>> putPassword(@Body UserRepository mail);



    @GET(ConstantValues.PATH_GET_EMAIL)
    Call<UserRepository> getAccountData(@Path("mail") String email);

    @GET(ConstantValues.PATH_EXIST_MAIL)
    Call<Map<String, Boolean>> emailExist(@Path("mail") String mail);

    @GET(ConstantValues.PATH_LOGIN)
    Call<Map<String, String>> loginUser(@Path("mail") String mail, @Path("password") String password);

    @GET(ConstantValues.PATH_GET_CODE_INFO)
    Call<CodesValidator> getCodesInfo(@Path("reset_code") String code);




}
