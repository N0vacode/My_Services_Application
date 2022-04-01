/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.specifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import app.novacode.myservices.R;
import app.novacode.myservices.pages.dashboard.DashBoard;
import app.novacode.myservices.widgets.AlertMsm;
import app.novacode.myservices.widgets.CreateServiceDialog;

public class ServiceInfo extends AppCompatActivity {

    FloatingActionButton backButton;
    Button ratingDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_info);

        backButton = (FloatingActionButton) findViewById(R.id.backButton);
        ratingDialogButton = (Button) findViewById(R.id.ratingDialogButton);


        Intent backDashboard = new Intent(this, DashBoard.class);





        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(backDashboard);

            }
        });

        ratingDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmStartRating();
                //AlertMsm
            }
        });
    }

    public void confirmStartRating() {

        DialogFragment newFragment = new AlertMsm();
        newFragment.show(getSupportFragmentManager(), "game");

    }
}