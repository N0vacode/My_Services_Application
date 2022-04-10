/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.specifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import app.novacode.myservices.R;
import app.novacode.myservices.pages.dashboard.DashBoard;

public class ServiceEdit extends AppCompatActivity {

    FloatingActionButton backButton2 ;
    ListView servicesListSeller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_edit);

        backButton2 = (FloatingActionButton) findViewById(R.id.backButton2);
        servicesListSeller = (ListView) findViewById(R.id.servicesListSeller);


        ArrayAdapter<CharSequence> arrayAdapterService = ArrayAdapter.createFromResource(this, R.array.countrys, android.R.layout.simple_list_item_1);
        servicesListSeller.setAdapter(arrayAdapterService);





        Intent backHome = new Intent(this, DashBoard.class);

        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(backHome);
            }
        });


        servicesListSeller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ServiceEdit.this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
}