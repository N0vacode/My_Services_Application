/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.rules;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import app.novacode.myservices.R;

public class Validation {

    public static boolean data(EditText editText, String errorMsm, String typeData ){

        String data = editText.getText().toString();

        if( data.length() > 0) {

            switch (typeData){
                case "mail":

                    if(data.contains("@") && data.contains(".") )
                        return true;
                    else
                        editText.setError("Your email must contain @ and . ");
                    return false;

                case "password":

                    if(data.length() < 6) {
                        editText.setError("Your password must contain at least 6 characters");
                        return false;
                    }
                    return true;

                case "firtName":
                    if(data.length() <2){
                        editText.setError("Your first name must contain at least 2 characters");
                        return false;
                    }
                    return true;

                case "secondName":

                    if(data.length() <2){
                        editText.setError("Your second name must contain at least 2 characters");
                        return false;
                    }
                    return true;

            }

        }else{

            editText.setError(errorMsm);
            return false;

        }

        return true;

    }


}
