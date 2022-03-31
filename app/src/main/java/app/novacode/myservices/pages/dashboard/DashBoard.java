/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import app.novacode.myservices.GridAdapter;
import app.novacode.myservices.R;
import app.novacode.myservices.databinding.ActivityMainBinding;
import app.novacode.myservices.widgets.ServicesAdapter;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DashBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar app_bar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    GridView servicesList;
    ActivityMainBinding binding;
    EditText search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_dash_board);
        //setContentView(binding.getRoot());


        navigationView = (NavigationView) findViewById(R.id.navigationView);
        app_bar = (Toolbar) findViewById(R.id.appBar);
        app_bar.setTitle("");
        app_bar.setSubtitle("");

        drawerLayout = findViewById(R.id.drawer);
        servicesList = (GridView) findViewById(R.id.servicesList);




        navigationView.setFitsSystemWindows(true);
        navigationView.setNavigationItemSelectedListener(this);

        setSupportActionBar(app_bar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, app_bar, R.string.open, R.string.close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);



        String[] flawerNames = {
                "Rose",
                "Lotus",
                "Lily",
                "Jasmine",
                "Violete",
                "Mar",
                "Rose",
                "Lotus",
                "Lily",
                "Jasmine",
                "Violete",
                "Mar",
                "Ocean",
                "Snappa",
                "Calamar",
                "Rose",
                "Lotus",
                "Lily",
                "Jasmine",
                "Violete",
                "Mar",
                "Rose",
                "Lotus",
                "Lily",
                "Jasmine",
                "Violete",
                "Mar",
                "Ocean",
                "Snappa",
                "Calamar",
                "Turutume"};
        int[] flawersImage = {
                R.drawable.ic_art,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_brasswork,
                R.drawable.ic_art,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_art,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_brasswork,
                R.drawable.ic_art,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_brasswork,
                R.drawable.ic_carpenter,
                R.drawable.ic_electronic};

        GridAdapter gridAdapter = new GridAdapter(DashBoard.this, flawerNames, flawersImage);
        servicesList.setAdapter(gridAdapter);


        servicesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.carpentry:

                Toast.makeText(getApplicationContext(), "Home BUtton", Toast.LENGTH_LONG).show();


                break;
            case R.id.plumbing:
                Toast.makeText(getApplicationContext(), "Personas", Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return false;
    }



}