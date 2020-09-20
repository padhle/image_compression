package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.Utilities.ScalingUtilities;
import com.example.myapplication.Utilities.ViewUtils;
import com.example.myapplication.controllers.CustomButton;
import com.example.myapplication.controllers.MultiShapeButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 25;

    //    @BindView(R.id.source_view)
//    ImageView mSourceView;
//    @BindView(R.id.destination_view)
//    ImageView mDestinationView;
//    @BindView(R.id.choose_image)
//    CustomButton chooseImage;
    @BindView(R.id.compress_image)
    MultiShapeButton mCompressImage;

    @BindView(R.id.compress_folder)
    MultiShapeButton mCompressFolder;

    String backgroundColor = "#ff00ff";
    String textColor = "#000000";

    private View.OnClickListener goToCustomizeCompressionScreen = v -> {
        Intent intent = new Intent(MainActivity.this, CustomizeCompressionActivity.class);
        intent.putExtra(Constants.RESOURCE_TO_COMPRESS,Constants.IMAGE);
        startActivity(intent);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mCompressImage.setOnClickListener(v -> startActivity(ViewUtils.getCompressionIntent(MainActivity.this,Constants.IMAGE)));

        mCompressFolder.setOnClickListener(v -> startActivity(ViewUtils.getCompressionIntent(MainActivity.this,Constants.FOLDER)));


//        chooseImage.setBackgroundColor(Color.parseColor(backgroundColor));
//        chooseImage.setTitle(getString(R.string.choose_image));
//        chooseImage.setTag(getString(R.string.choose_image));
//        chooseImage.setTextColor(Color.parseColor(textColor));
//        chooseImage.setOnClickListener(v -> chooseImage());
    }

    public void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE) {
            if (data != null) {
                Uri uri = data.getData();
                Bitmap bitmap = ScalingUtilities.getBitmap(MainActivity.this, uri);
                if (bitmap != null) {
//                    mSourceView.setImageURI(uri);
                    Bitmap scaledBitmap = null;
                    if (uri != null) {
                        scaledBitmap = ScalingUtilities.decodeFile(uri.toString(), 200, 200, ScalingUtilities.ScalingLogic.CROP);
//                        mDestinationView.setImageBitmap(scaledBitmap);
                    }


                    String sizeInfo = null;
                    if (scaledBitmap != null) {
                        sizeInfo = String.format("size of source bitmap is %1$s and size of destination bitmap is %2$s",
                                ScalingUtilities.getSize(bitmap), ScalingUtilities.getSize(scaledBitmap));
                    }

                    Toast.makeText(MainActivity.this, sizeInfo, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}