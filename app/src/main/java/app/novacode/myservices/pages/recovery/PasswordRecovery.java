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
import androidx.appcompat.app.AppCompatActivity;
import app.novacode.myservices.R;
import app.novacode.myservices.entity.CodesValidator;
import app.novacode.myservices.repository.UserRepository;


public class PasswordRecovery extends AppCompatActivity {
    EditText mailAccountRecovery;
    Button sendCodeButton;
    UserRepository userRecovery = new UserRepository();
    CodesValidator codesValidator = new CodesValidator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_recovery);

        final Intent intentCodeValidator = new Intent(this, CodeValidator.class);

        mailAccountRecovery = (EditText) findViewById(R.id.mailAccountRecovery);
        sendCodeButton      = (Button) findViewById(R.id.sendCodeButton);


        sendCodeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                userRecovery.setEmailReset(mailAccountRecovery.getText().toString());

                codesValidator.sendCodeToMail(PasswordRecovery.this, userRecovery);


            }

        });



    }


}