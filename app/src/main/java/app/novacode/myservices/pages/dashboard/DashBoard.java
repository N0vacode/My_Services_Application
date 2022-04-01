/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.pages.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import app.novacode.myservices.GridAdapter;
import app.novacode.myservices.R;
import app.novacode.myservices.databinding.ActivityMainBinding;
import app.novacode.myservices.widgets.CreateServiceDialog;

import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class DashBoard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar app_bar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    GridView servicesList;
    ActivityMainBinding binding;
    EditText search;
    FloatingActionButton searchData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_dash_board);


        navigationView = (NavigationView) findViewById(R.id.navigationView);
        app_bar = (Toolbar) findViewById(R.id.appBar);
        app_bar.setTitle("");
        app_bar.setSubtitle("");
        search = (EditText) findViewById(R.id.search);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        servicesList = (GridView) findViewById(R.id.servicesList);
        searchData = (FloatingActionButton) findViewById(R.id.searchData);




        navigationView.setFitsSystemWindows(true);
        navigationView.setNavigationItemSelectedListener(this);

        setSupportActionBar(app_bar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, app_bar, R.string.open, R.string.close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);



        String[] serviceNames = {
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
        int[] serviceImage = {
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
        int[] rates = {
                R.drawable.rating,
                R.drawable.rating1_5,
                R.drawable.rating2,
                R.drawable.rating5,
                R.drawable.rating2,
                R.drawable.rating3_5,
                R.drawable.rating,
                R.drawable.rating1_5,
                R.drawable.rating2,
                R.drawable.rating5,
                R.drawable.rating2,
                R.drawable.rating3_5,
                R.drawable.rating,
                R.drawable.rating1_5,
                R.drawable.rating2,
                R.drawable.rating5,
                R.drawable.rating2,
                R.drawable.rating3_5,
                R.drawable.rating,
                R.drawable.rating1_5,
                R.drawable.rating2,
                R.drawable.rating5,
                R.drawable.rating2,
                R.drawable.rating3_5,
                R.drawable.rating,
                R.drawable.rating1_5,
                R.drawable.rating2,
                R.drawable.rating5,
                R.drawable.rating2,
                R.drawable.rating3_5,
                R.drawable.rating,
                R.drawable.rating1_5,
                R.drawable.rating2,
                R.drawable.rating5,
                R.drawable.rating2,
                R.drawable.rating3_5};


        GridAdapter gridAdapter = new GridAdapter(DashBoard.this, serviceNames, serviceImage,rates);
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

                Toast.makeText(getApplicationContext(), "Home Button", Toast.LENGTH_LONG).show();
                confirmStartGame();
                break;

            case R.id.plumbing:
                Toast.makeText(getApplicationContext(), "Personas", Toast.LENGTH_LONG).show();
                break;

            default:
        }
        return false;
    }
    public void confirmStartGame() {

        DialogFragment newFragment = new CreateServiceDialog();
        newFragment.show(getSupportFragmentManager(), "game");

    }


}