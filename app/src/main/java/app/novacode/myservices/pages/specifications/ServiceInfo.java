/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.specifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import app.novacode.myservices.R;
import app.novacode.myservices.pages.dashboard.DashBoard;
import app.novacode.myservices.widgets.AlertMsm;
import app.novacode.myservices.widgets.DialogType;

public class ServiceInfo extends AppCompatActivity {

    FloatingActionButton backButton;
    Button ratingDialogButton;
    RatingBar ratingBar;
    int ratingB;

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

                //TODO: Make Rating data
                AlertMsm newFragment = new AlertMsm("Rating",
                        "Add a rating for this seller of service, remember that this rating should be based on your experience using the service, attention and prices compared to quality.");
                newFragment.setDialogType(DialogType.RATE);
                newFragment.show(getSupportFragmentManager(), "Rate Service");

               // confirmStartRating();
                //AlertMsm
            }
        });
    }
}