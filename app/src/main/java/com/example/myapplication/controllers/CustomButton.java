package com.example.myapplication.controllers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;


public class CustomButton extends ConstraintLayout{
    View rootView;
    TextView mTitle;

    public CustomButton(Context context) {
        super(context);
        initialize(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context);
    }

    public void initialize(Context context){
        rootView=LayoutInflater.from(context).inflate(R.layout.btn_layout,this,true);
        mTitle=rootView.findViewById(R.id.title);
    }

    public void setTitle(String value){
        mTitle.setText(value);
    }

    public void setTag(String title){
        rootView.setTag(title);
    }

    public void setTextColor(int color) {
        mTitle.setTextColor(color);
    }
}
