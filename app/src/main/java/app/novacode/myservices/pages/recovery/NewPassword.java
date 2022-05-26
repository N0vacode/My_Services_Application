/*
 * Copyright (c) $2019 NativeCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.R;
import app.novacode.myservices.repository.UserRepository;
import app.novacode.myservices.rules.Validation;
import app.novacode.myservices.services.MD5C;

public class NewPassword extends AppCompatActivity {

    EditText newPassword;
    EditText reNewPasswrd;
    Button btnValidateCode;

    UserRepository userRepository = new UserRepository();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        newPassword = (EditText) findViewById(R.id.newPassword);
        reNewPasswrd = (EditText) findViewById(R.id.reNewPasswrd);
        btnValidateCode = (Button) findViewById(R.id.btnValidateCode);


        btnValidateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MD5C.setUserData(reNewPasswrd.getText().toString());
                String md5Password = MD5C.convert();
                
                if ( newPassword.getText().toString().equals(reNewPasswrd.getText().toString()) ){


                    if (Validation.data(newPassword,"Password Invalid", "password")){
                        userRepository.setUsEmail(getIntent().getStringExtra(ConstantValues.USER_MAIL_KEY));
                        userRepository.setUsPassword(md5Password);

                        userRepository.changePassword(NewPassword.this,userRepository);
                    }
                    
                    
                    
                }else{

                    Toast.makeText(NewPassword.this, "Passwords Do Not Match", Toast.LENGTH_SHORT).show();
                    
                }
                
                

            }
        });


    }


}