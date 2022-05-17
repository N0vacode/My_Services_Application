/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.recovery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import app.novacode.myservices.ConstantValues;
import app.novacode.myservices.R;
import app.novacode.myservices.entity.CodesValidator;

public class CodeValidator extends AppCompatActivity {


    EditText codeAccountValidate;
    Button btnValidateCode;

    CodesValidator codesValidator = new CodesValidator();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_validator);

        btnValidateCode = (Button) findViewById(R.id.btnValidateCode);
        codeAccountValidate = (EditText) findViewById(R.id.codeAccountValidate);


        btnValidateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                codesValidator.getCodeInfo(CodeValidator.this, codeAccountValidate.getText().toString());

            }
        });








    }




}