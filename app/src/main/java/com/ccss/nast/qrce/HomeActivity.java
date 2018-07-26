package com.ccss.nast.qrce;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    int[] photos ={R.drawable.c_programming, R.drawable.cplus,R.drawable.csharp,R.drawable.java, R.drawable.asp,R.drawable.os,R.drawable.software_engineering,R.drawable.maths};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_home);
    }

    protected void onPause(){
        super.onPause();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
