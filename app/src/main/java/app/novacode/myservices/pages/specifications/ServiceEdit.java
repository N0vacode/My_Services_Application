/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.specifications;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import app.novacode.myservices.R;
import app.novacode.myservices.pages.dashboard.DashBoard;

public class ServiceEdit extends AppCompatActivity {

    FloatingActionButton backButton2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_edit);

        backButton2 = (FloatingActionButton) findViewById(R.id.backButton2);


        Intent backHome = new Intent(this, DashBoard.class);

        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(backHome);
            }
        });
    }
}