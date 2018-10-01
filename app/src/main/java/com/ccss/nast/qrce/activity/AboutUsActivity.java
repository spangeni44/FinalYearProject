package com.ccss.nast.qrce.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ccss.nast.qrce.R;

public class AboutUsActivity extends AppCompatActivity {
    TextView tv_header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
//        tv_header=findViewById(R.id.header);
//        tv_header.setText((R.string.nav_about_us));
    }
}
