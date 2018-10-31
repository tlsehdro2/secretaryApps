package com.example.junho.secretaryapps;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;

public class PermissionActivity extends AppCompatActivity {

    TextView locationTxtView,storageTxtView,audioTxtView;
    ImageButton imageButton, imageButton2, imageButton3;
    Button allowButton;
    PermissionChecker perChecker = new PermissionChecker();
    Intent resIntent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        locationTxtView = (TextView) findViewById(R.id.locationTxtView);
        storageTxtView = (TextView) findViewById(R.id.storageTxtView);
        audioTxtView = (TextView) findViewById(R.id.audioTxtView);
        allowButton = (Button) findViewById(R.id.allowButton);

        allowButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                boolean checkResult = perChecker.checkPermission(getApplicationContext(),PermissionActivity.this);

                if(checkResult) {
                    resIntent.putExtra("result",true);
                    setResult(RESULT_OK, resIntent);

                    finish();
                }else{
                    resIntent.putExtra("result",false);
                    setResult(RESULT_OK,resIntent);

                    finish();
                }
            }
        });
    }

    public void visibleLocationTxt(View v){
        if(View.GONE==(locationTxtView.getVisibility())){
            locationTxtView.setVisibility(View.VISIBLE);
        }else{
            locationTxtView.setVisibility(View.GONE);
        }
    }
    public void visibleStorageTxt(View v){
        if(View.GONE==(storageTxtView.getVisibility())){
            storageTxtView.setVisibility(View.VISIBLE);
        }else{
            storageTxtView.setVisibility(View.GONE);
        }
    }
    public void visibleAudioTxt(View v){
        if(View.GONE==(audioTxtView.getVisibility())){
            audioTxtView.setVisibility(View.VISIBLE);
        }else{
            audioTxtView.setVisibility(View.GONE);
        }
    }
}
