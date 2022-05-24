/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.entity;


import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.io.File;
import java.util.Map;

import app.novacode.myservices.MainActivity;
import app.novacode.myservices.repository.BusinessRepository;
import app.novacode.myservices.repository.UserRepository;
import app.novacode.myservices.services.ApiService;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Seller extends UserRepository {


    public void signUpSeller(Context context, UserRepository userData, BusinessRepository businessRepository){
        Intent intentMainActivity = new Intent(context, MainActivity.class);


        Call<UserRepository> userRepositoryCall = ApiService.getUserService().creteAccount(userData);

        userRepositoryCall.enqueue(new Callback<UserRepository>() {

            @Override
            public void onResponse(Call<UserRepository> call, Response<UserRepository> response) {

                if (response.isSuccessful()) {

                    intentMainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    assert response.body() != null;
                    businessRepository.setSellerId(response.body().getUserId());

                    signUpBusiness(context, businessRepository);
                }

            }

            @Override
            public void onFailure(Call<UserRepository> call, Throwable t) {
                System.out.println(t + " Seller 51");
//                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });

    }


    protected void signUpBusiness(Context context, BusinessRepository businessRepository){
        Intent intentMainActivity = new Intent(context, MainActivity.class);

//
//        //Create a file object using file path
//        File file = new File(filePath);
//        // Create a request body with file and image media type
//        RequestBody fileReqBody = RequestBody.create(MediaType.parse("image/*"), file);
//        // Create MultipartBody.Part using file request-body,file name and part name
//        MultipartBody.Part part = MultipartBody.Part.createFormData("upload", file.getName(), fileReqBody);
//        //Create request body with text description and text media type
//       // RequestBody description = RequestBody.create(MediaType.parse("text/plain"), "image-type");
//        //

        Call<BusinessRepository> userRepositoryCall = ApiService.getUserService().saveBusiness(businessRepository);

        userRepositoryCall.enqueue(new Callback<BusinessRepository>() {

            @Override
            public void onResponse(Call<BusinessRepository> call, Response<BusinessRepository> response) {


                if (response.isSuccessful()) {


                    intentMainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    context.startActivity(intentMainActivity);

                    Toast.makeText(context, "Account And Business Created", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<BusinessRepository> call, Throwable t) {
                // todo: Problema de formato de imagen BEGIN_ARRAY
                System.out.println(t + " Seller 86");
                context.startActivity(intentMainActivity);
                Toast.makeText(context, "Done!", Toast.LENGTH_SHORT).show();
//                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });

    }

}
