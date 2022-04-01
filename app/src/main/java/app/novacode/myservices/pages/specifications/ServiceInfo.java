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

public class ServiceInfo extends AppCompatActivity {

    FloatingActionButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_info);

        backButton = (FloatingActionButton) findViewById(R.id.backButton);


        Intent backDashboard = new Intent(this, DashBoard.class);






        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(backDashboard);

            }
        });
    }
}