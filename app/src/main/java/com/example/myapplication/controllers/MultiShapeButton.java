package com.example.myapplication.controllers;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;

public class MultiShapeButton extends ConstraintLayout {

    View rootView;
    TextView mTitle;
    String titleText;
    int backgroundColor,titleTextColor;
    View backgroundView;

    public static final String GREY_COLOR="#808080";
    public static final String DARK_BROWN_COLOR="#D2691E";
    public static final String WHITE_COLOR="#FFFFFF";
    public static final String BLACK_COLOR="#000000";

    public MultiShapeButton(Context context) {
        super(context);
        initialize(context,null);
    }

    public MultiShapeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context,attrs);
    }

    public MultiShapeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize(context,attrs);
    }

    public void initialize(Context context,AttributeSet attrs){
        if(attrs != null){
            TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.MultiShapeButton);
            try{
                titleText=typedArray.getString(R.styleable.MultiShapeButton_title_text);
                backgroundColor=typedArray.getInt(R.styleable.MultiShapeButton_background_color,1);
                titleTextColor=typedArray.getInt(R.styleable.MultiShapeButton_title_text_color,1);
            }finally {
                typedArray.recycle();
            }
        }

        rootView= LayoutInflater.from(context).inflate(R.layout.multi_shape_button,this,true);
        mTitle=rootView.findViewById(R.id.title);
        backgroundView=rootView.findViewById(R.id.button_background);

        if(!TextUtils.isEmpty(titleText)){
            mTitle.setText(titleText);
        }
        setBackgroundColorOfView(backgroundColor);
        setTitleTextColor(titleTextColor);
    }

    private void setBackgroundColorOfView(int backgroundColor) {
        Drawable drawable = backgroundView.getBackground().mutate();
        switch(backgroundColor){
            case 1:
                drawable.setColorFilter(Color.parseColor(GREY_COLOR), PorterDuff.Mode.MULTIPLY);
                break;

            case 2:
                drawable.setColorFilter(Color.parseColor(DARK_BROWN_COLOR), PorterDuff.Mode.MULTIPLY);
                break;

        }
        backgroundView.setBackground(drawable);
    }

    private void setTitleTextColor(int titleTextColor) {
        switch(titleTextColor){
            case 1:
                mTitle.setTextColor(Color.parseColor(WHITE_COLOR));
                break;

            case 2:
                mTitle.setTextColor(Color.parseColor(BLACK_COLOR));
                break;

        }
    }
}
