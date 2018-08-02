package com.ccss.nast.qrce.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ccss.nast.qrce.R;
import com.ccss.nast.qrce.fragment.HomeFragment;
import com.ccss.nast.qrce.fragment.LoksewaFragment;
import com.ccss.nast.qrce.fragment.NEAFragment;
import com.ccss.nast.qrce.fragment.NTCFragment;
import com.ccss.nast.qrce.fragment.SettingsFragment;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    private void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
         @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

             android.app.Fragment fragment;
             android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
             int id=item.getItemId();
             Toast.makeText(getApplicationContext(),"Item id= "+id,Toast.LENGTH_SHORT).show();
             switch(id){
                 case 0: {
                     fragment = new HomeFragment();
                     transaction.replace(R.id.fl_main_frame, fragment);
                     transaction.addToBackStack(null);
                     transaction.commit();
                     break;
                 }
                 case 1: {
                     fragment = new NTCFragment();
                     transaction.replace(R.id.fl_main_frame, fragment);
                     transaction.addToBackStack(null);
                     transaction.commit();
                     break;
                 }
                 case 2:
                     fragment = new NEAFragment();
                     transaction.replace(R.id.fl_main_frame,fragment);
                     transaction.addToBackStack(null);
                     transaction.commit();
                     break;

                 default:{
                     fragment=new HomeFragment();
                     transaction.replace(R.id.fl_main_frame,fragment);
                     transaction.addToBackStack(null);
                     transaction.commit();
                     break;
                 }
             }
        return false;
    }
}


