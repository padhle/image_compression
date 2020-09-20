package com.example.myapplication.Utilities;

import android.content.Context;
import android.content.Intent;

import com.example.myapplication.Constants;
import com.example.myapplication.CustomizeCompressionActivity;

public class ViewUtils {

    public static Intent getCompressionIntent(Context context, String resource_type){
        Intent intent=new Intent(context, CustomizeCompressionActivity.class);
        intent.putExtra(Constants.RESOURCE_TO_COMPRESS,resource_type);
        return intent;
    }
}
