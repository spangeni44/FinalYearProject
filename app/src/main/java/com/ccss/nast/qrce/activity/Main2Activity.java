package com.ccss.nast.qrce.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpToolbar();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

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

        Fragment fragment;
        int id = item.getItemId();
        //  String id=item.getTitle().toString();
        Toast.makeText(getApplicationContext(), "Item id= " + id, Toast.LENGTH_SHORT).show();
        switch (id) {
            case R.id.nav_home: {
                fragment = new HomeFragment();
                loadFragment(fragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.nav_ntc: {
                fragment = new NTCFragment();
                loadFragment(fragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.nav_nea: {
                fragment = new NEAFragment();
                loadFragment(fragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.nav_loksewa: {
                fragment = new LoksewaFragment();
                loadFragment(fragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.nav_settings: {
                fragment = new SettingsFragment();
                loadFragment(fragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.nav_about_us: {
                Intent aboutUsIntent = new Intent(Main2Activity.this, AboutUsActivity.class);
                startActivity(aboutUsIntent);
                break;
            }
            case R.id.nav_privacy_policy: {
                Intent privacyPolicyIntent = new Intent(Main2Activity.this, PrivacyPolicyActivity.class);
                startActivity(privacyPolicyIntent);
                break;
            }
            default: {
                fragment = new HomeFragment();
//                transaction.replace(R.id.fl_main_frame, fragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main_frame, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}


