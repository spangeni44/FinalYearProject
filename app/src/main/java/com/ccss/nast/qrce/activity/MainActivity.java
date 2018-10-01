package com.ccss.nast.qrce.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.ccss.nast.qrce.R;
import com.ccss.nast.qrce.fragment.Fragment1;
import com.ccss.nast.qrce.fragment.Fragment2;
import com.ccss.nast.qrce.helpers.GridSpacingItemDecoration;
import com.ccss.nast.qrce.helpers.RecyclerViewAdapter;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MyListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private FloatingActionButton fab;
    List<String> strings;
    TextView tv_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tv_header=findViewById(R.id.header);
//        tv_header.setText((R.string.nav_home));

//        strings = getResources().getStringArray(R.array.subjects);
//
//        setListAdapter(new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_checked, presidents));
//    }
        strings = new ArrayList<>();
        strings.add("C Programming");
        strings.add("Basic Electrical");
        strings.add("OOP in C++");
        strings.add("Data Structures and Algorithms");
        strings.add("Electronic Devices and Circuit");
        strings.add("Logic Circuits");
        strings.add("Database Management System");
        strings.add("Microprocessor");
        strings.add("C#");
        strings.add("Java");
        strings.add("Mathematics");
        strings.add("Computer Graphics");
        strings.add("Theory of Computation");
        strings.add("Numerical Methods");
        strings.add("Object Oriented Software Engineering");
        strings.add("Data Communication");
        strings.add("Simulation and Modeling");
        strings.add("Embedded System");
        strings.add("Operating System");
        strings.add("Artificial Intelligence");
        strings.add("Computer Networks");
        strings.add("Digital Signal Processing");
        strings.add("Information System");
        strings.add("Social and Professional Issues in IT");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager;
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        int spanCount = 2;
        int spacing = 8;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount,spacing));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, strings);
        recyclerView.setAdapter(adapter);

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
        //  Toast.makeText(getApplicationContext(), "Item id= " + id, Toast.LENGTH_SHORT).show();
        switch (id) {
            case R.id.nav_home: {
//                fragment = new HomeFragment();
//                loadFragment(fragment);
                drawerLayout.closeDrawers();
                break;
            }
            case R.id.nav_ntc: {
//                fragment = new NTCFragment();
//                loadFragment(fragment);
                drawerLayout.closeDrawers();
                Intent ntcIntent = new Intent(MainActivity.this, NTCActivity.class);
                startActivity(ntcIntent);
                break;
            }
            case R.id.nav_nea: {
//                fragment = new NEAFragment();
//                loadFragment(fragment);
                drawerLayout.closeDrawers();
                Intent neaIntent = new Intent(MainActivity.this, NEAActivity.class);
                startActivity(neaIntent);
                break;
            }
            case R.id.nav_loksewa: {
//                fragment = new LoksewaFragment();
//                loadFragment(fragment);
                drawerLayout.closeDrawers();
                Intent lokSewaIntent = new Intent(MainActivity.this, LokSewaActivity.class);
                startActivity(lokSewaIntent);
                break;
            }
            case R.id.nav_settings: {

//                fragment = new SettingsFragment();
//                loadFragment(fragment);
                drawerLayout.closeDrawers();
                Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settingsIntent);
                break;
            }
            case R.id.nav_about_us: {
                drawerLayout.closeDrawers();
                Intent aboutUsIntent = new Intent(MainActivity.this, AboutUsActivity.class);
                startActivity(aboutUsIntent);
                break;
            }
            case R.id.nav_privacy_policy: {
                Intent privacyPolicyIntent = new Intent(MainActivity.this, PrivacyPolicyActivity.class);
                startActivity(privacyPolicyIntent);
                break;
            }
            default: {
                drawerLayout.closeDrawers();
                //              fragment = new HomeFragment();
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
        LinearLayout frame=new LinearLayout(this);
        fragmentTransaction.replace(frame.getId(),fragment);
       // fragmentTransaction.add(R.id.fl_main_frame, fragment).commit();
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

    @Override
    public void onRecyclerViewItemClick(String type) {
        Intent intent=new Intent(getBaseContext(),QuestionsActivity.class);
        intent.putExtra("SubjectType",type);

    }
}


