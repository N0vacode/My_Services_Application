/*
 * Copyright (c) $2019 NativeCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.services;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Map;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.pages.dashboard.DashBoard;
import app.novacode.myservices.repository.UserRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends UserRepository {



    public static void user(Context context, String mailUser, String password){


        final Intent dashboard = new Intent(context, DashBoard.class); // Intent Dashboar Activity


        Call<Map<String, String>> userRepositoryCall = ApiService.getUserService().loginUser(mailUser, password);

        userRepositoryCall.enqueue(new Callback<Map<String, String>>() {


            @Override
            public void onResponse(Call<Map<String, String>> call, Response<Map<String, String>> response) {

                if(response.isSuccessful()){


                    if(response.body().get("response").equals("Valid")){


                        // Passing data to next Activity Data.
                        dashboard.putExtra(ConstantValues.USER_MAIL_KEY, mailUser);
                        dashboard.putExtra(ConstantValues.USER_FNAME_KEY, response.body().get(ConstantValues.USER_FNAME_KEY));
                        dashboard.putExtra(ConstantValues.USER_ID_KEY, response.body().get(ConstantValues.USER_ID_KEY));
                        dashboard.putExtra(ConstantValues.USER_ROL_KEY, response.body().get(ConstantValues.USER_ROL_KEY));


                        context.startActivity(dashboard);

                        Toast.makeText(context, "Login Sussed ", Toast.LENGTH_SHORT).show();

                    }else{

                        Toast.makeText(context, response.body().get("response"), Toast.LENGTH_SHORT).show();
                    }



                }else{

                    Toast.makeText(context, "We couldn't check your email", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {

                Toast.makeText(context, "Error: Failure wen call Data, Check our Internet Conexion", Toast.LENGTH_SHORT).show();

            }
        });


    }



}
