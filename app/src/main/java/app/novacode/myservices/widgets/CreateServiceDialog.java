/*
 * Copyright (c) $2019 NativeCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.widgets;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import app.novacode.myservices.R;
import app.novacode.myservices.entity.Services;
import retrofit2.Call;

public class CreateServiceDialog extends DialogFragment {

    EditText titleService;
    EditText specificationsData;
    EditText priceNewService;
    Button createService;
    ProgressBar creatingService;
    private final int userId;
    private final String contact;
    private final boolean done = false;

    public CreateServiceDialog(int userId, String contact){
        this.userId = userId;
        this.contact = contact;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Services services = new Services();

        View v = inflater.inflate(R.layout.register_service_dialog, container, false);

        titleService  =  v.findViewById(R.id.titleService);
        createService = v.findViewById(R.id.createService);
        priceNewService    = v.findViewById(R.id.priceNewService);
        specificationsData = v.findViewById(R.id.specificationsData);

        creatingService = v.findViewById(R.id.creatingService);
        creatingService.setVisibility(View.GONE);



        createService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createService.setVisibility(View.GONE);
                creatingService.setVisibility(View.VISIBLE);

                try {

                    services.setNameService(titleService.getText().toString());
                    services.setSpecializationService(specificationsData.getText().toString());
                    services.setContactService(contact);


                    services.setPriceService(Float.parseFloat(priceNewService.getText().toString()));
                    services.setIdBusiness(String.valueOf(userId));

                    services.createService(services, getContext());

                    createService.setVisibility(View.VISIBLE);
                    creatingService.setVisibility(View.GONE);

                    titleService.setText("");
                    specificationsData.setText("");
                    priceNewService.setText("");




                }catch (Exception e){

                    Toast.makeText(v.getContext(), "Shoulbe writte data", Toast.LENGTH_SHORT).show();

                    createService.setVisibility(View.VISIBLE);
                    creatingService.setVisibility(View.GONE);
                }








            }
        });

        return v;
    }

}
