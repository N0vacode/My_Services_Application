/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.entity;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.Map;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.pages.recovery.CodeValidator;
import app.novacode.myservices.pages.recovery.NewPassword;
import app.novacode.myservices.repository.UserRepository;
import app.novacode.myservices.services.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CodesValidator {

    private int idReset;
    private String codeReset;
    private String codeStatus;
    private String emailReset;


    public CodesValidator(int idReset, String codeReset, String codeStatus, String emailReset) {
        this.idReset = idReset;
        this.codeReset = codeReset;
        this.codeStatus = codeStatus;
        this.emailReset = emailReset;
    }

    public CodesValidator(){}


    public void sendCodeToMail(Context context, Object mailData){

        final Intent intentCodeValidator = new Intent(context, CodeValidator.class);

        Call<Map<String, String>> userRepositoryCall = ApiService.getUserService().sendCodeToRecoveryPassword(mailData);

        userRepositoryCall.enqueue(new Callback<Map<String, String>>() {

            @Override
            public void onResponse(@NonNull Call<Map<String, String>> call, @NonNull Response<Map<String, String>> response) {


                if ( response.isSuccessful() ) {



                    if( response.body().containsKey("noExist") )
                        Toast.makeText(context, response.body().get("noExist"), Toast.LENGTH_SHORT).show();

                    if( response.body().containsKey("unSusses") )
                        Toast.makeText(context, response.body().get("unSusses"), Toast.LENGTH_SHORT).show();

                    if( response.body().containsKey("susses") ) {

                        intentCodeValidator.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                        intentCodeValidator.putExtra(ConstantValues.USER_MAIL_KEY, mailData.toString());

                        context.startActivity(intentCodeValidator);

                        Toast.makeText(context, response.body().get("susses"), Toast.LENGTH_SHORT).show();

                    }



                }


            }

            @Override
            public void onFailure(Call<Map<String, String>> call, Throwable t) {
                System.out.println(t);
//                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });

    }


    public void getCodeInfo(Context context, String codeData){


        Call<CodesValidator> userRepositoryCall = ApiService.getUserService().getCodesInfo(codeData);

        userRepositoryCall.enqueue(new Callback<CodesValidator>() {
            @Override
            public void onResponse(Call<CodesValidator> call, Response<CodesValidator> response) {

                if(response.isSuccessful()){

                    if(response.body() != null){

                        CodesValidator codesValidator = new CodesValidator(
                                Integer.parseInt(String.valueOf(response.body().idReset)),
                                response.body().codeReset,
                                "Inactive",
                                response.body().emailReset
                                );

                        if( response.body().codeReset.equals(codeData) && response.body().codeStatus.equals("Active") ){


                            putDataCode(context, codesValidator);


                        }else{

                            Toast.makeText(context, "Code Invalid or Inactive", Toast.LENGTH_SHORT).show();

                        }

                    }

                }else{

                    Toast.makeText(context, "We couldn't check your code", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<CodesValidator> call, Throwable t) {

                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });



    }

    public void putDataCode(Context context, CodesValidator codesValidator){

        final Intent intentCodeValidator = new Intent(context, NewPassword.class);

        Call<CodesValidator> userRepositoryCall = ApiService.getUserService().sendPutCode(codesValidator);

        userRepositoryCall.enqueue(new Callback<CodesValidator>() {

            @Override
            public void onResponse(@NonNull Call<CodesValidator> call, @NonNull Response<CodesValidator> response) {


                if ( response.isSuccessful() ) {

                    intentCodeValidator.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    intentCodeValidator.putExtra(ConstantValues.USER_MAIL_KEY,codesValidator.getEmailReset());

                    context.startActivity(intentCodeValidator);

                    Toast.makeText(context, "Code Used", Toast.LENGTH_SHORT).show();

                }


            }

            @Override
            public void onFailure(Call<CodesValidator> call, Throwable t) {
                System.out.println(t);
//                Toast.makeText(context, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }

        });




    }











    public int getIdReset() {
        return idReset;
    }

    public void setIdReset(int idReset) {
        this.idReset = idReset;
    }

    public String getCodeReset() {
        return codeReset;
    }

    public void setCodeReset(String codeReset) {
        this.codeReset = codeReset;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getEmailReset() {
        return emailReset;
    }

    public void setEmailReset(String emailReset) {
        this.emailReset = emailReset;
    }
}
