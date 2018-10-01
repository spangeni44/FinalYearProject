package com.ccss.nast.qrce.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ccss.nast.qrce.R;

public class NTCActivity extends AppCompatActivity {
    TextView tv_header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ntc);
//        tv_header=findViewById(R.id.header);
//        tv_header.setText(("NTC"));
    }
}
