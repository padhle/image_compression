package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class CustomizeCompressionActivity extends AppCompatActivity {

    public String resourceToCompress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_compression);

        Intent intent=getIntent();
        if(getIntent()!=null) resourceToCompress=intent.getStringExtra(Constants.RESOURCE_TO_COMPRESS);

        Toast.makeText(CustomizeCompressionActivity.this,resourceToCompress,Toast.LENGTH_LONG).show();
    }
}