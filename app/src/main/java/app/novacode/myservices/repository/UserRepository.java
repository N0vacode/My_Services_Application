/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.repository;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.MainActivity;
import app.novacode.myservices.pages.recovery.CodeValidator;
import app.novacode.myservices.pages.recovery.PasswordRecovery;
import app.novacode.myservices.services.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository{


    private String userFirstName;
    private String userSecondName;
    private String userCity;
    private String userMail;
    private String userPhone;
    private String userPassword;
    private String userRol;
    private String emailReset;


    private boolean mailExist;

    public void getUser(Context context, String email){

        Call<UserRepository> userRepositoryCall = ApiService.getUserService().getAccountData(email);

        userRepositoryCall.enqueue(new Callback<UserRepository>() {
            @Override
            public void onResponse(Call<UserRepository> call, Response<UserRepository> response) {

                if(response.isSuccessful()){

                    //TODO: SERIALIZE USER DATA

                }else{

                    Toast.makeText(context, "We couldn't check your email", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<UserRepository> call, Throwable t) {

                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


    public void signUpUser(Context context, Object userData){
        Intent intentMainActivity = new Intent(context, MainActivity.class);


        Call<UserRepository> userRepositoryCall = ApiService.getUserService().creteAccount(userData);

        userRepositoryCall.enqueue(new Callback<UserRepository>() {

            @Override
            public void onResponse(Call<UserRepository> call, Response<UserRepository> response) {

                    if (response.isSuccessful()) {

                        intentMainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        context.startActivity(intentMainActivity);

                        Toast.makeText(context, "Account Created", Toast.LENGTH_SHORT).show();
                    }

            }

            @Override
            public void onFailure(Call<UserRepository> call, Throwable t) {
                System.out.println(t);
//                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });



    }



    public void changePassword( Context context, UserRepository mailData ){



        Intent intentMainActivity = new Intent(context, MainActivity.class);


        // todo se debe enviar el mail y el password
        Call<Map<String, Object>> userRepositoryCall = ApiService.getUserService().putPassword(mailData);

        userRepositoryCall.enqueue(new Callback<Map<String, Object>>() {

            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {

                if (response.isSuccessful()) {

                    intentMainActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    context.startActivity(intentMainActivity);

                    if(response.body().get("statusPassword") != null) {

                        //TODO: CHANGE FOR DIALOG -> [Becuase the password is changed and need clear information] Include ok button

                        Toast.makeText(context, response.body().get("statusPassword").toString(), Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(context, "Failed to Change Password", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                System.out.println(t);
//                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });





    }

    public void mailExist( String email ) throws InterruptedException {
        Call<Map<String, Boolean>> userRepositoryCall = ApiService.getUserService().emailExist(email);

        userRepositoryCall.enqueue(new Callback<Map<String, Boolean>>() {


            @Override
            public void onResponse(Call<Map<String, Boolean>> call, Response<Map<String, Boolean>> response) {

                try{


                    if(response.isSuccessful()){

                        mailExist = response.body().get("existMail");
                    }

                }catch (Exception e){
                    System.out.println("Error: " + e.getMessage());
                }



            }

            @Override
            public void onFailure(Call<Map<String, Boolean>> call, Throwable t) {
                System.out.println(t);
            }

        });

        // TODO: Problem for validate Email.


    }




    public String getUsFirsName() {
        return userFirstName;
    }

    public void setUsFirsName(String usFirsName) {
        this.userFirstName = usFirsName;
    }

    public String getUsSecondName() {
        return userSecondName;
    }

    public void setUsSecondName(String usSecondName) {
        this.userSecondName = usSecondName;
    }

    public String getUsCity() {
        return userCity;
    }

    public void setUsCity(String usCity) {
        this.userCity = usCity;
    }

    public String getUsEmail() {
        return userMail;
    }

    public void setUsEmail(String usEmail) {
        this.userMail = usEmail;
    }

    public String getUsPhone() {
        return userPhone;
    }

    public void setUsPhone(String usPhone) {
        this.userPhone = usPhone;
    }

    public String getUsPassword() {
        return userPassword;
    }

    public void setUsPassword(String usPassword) {
        this.userPassword = usPassword;
    }

    public String getUsRol() {
        return userRol;
    }

    public void setUsRol(String usRol) {
        this.userRol = usRol;
    }

    public boolean isMailExist() {
        return mailExist;
    }

    public void setMailExist(boolean mailExist) {
        this.mailExist = mailExist;
    }


    public String getEmailReset() {
        return emailReset;
    }

    public void setEmailReset(String emailReset) {
        this.emailReset = emailReset;
    }
}
