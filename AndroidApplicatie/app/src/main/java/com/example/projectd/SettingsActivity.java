package com.example.projectd;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SettingsActivity extends AppCompatActivity {
    private static final int PERMISSION_CODE = 1000;
    public static int timer;
    Button BackButton;
    Button ForwardButton;
    TextInputEditText mTimerSecinpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        this.setContentView(R.layout.activity_settings);
        //TODO set the settings
        mTimerSecinpt = findViewById(R.id.timer);

        Intent camera = new Intent(SettingsActivity.this, CameraActivity.class);
        ForwardButton = findViewById(R.id.forward);
        ForwardButton.setOnClickListener(v ->{
            if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                String[] permission = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permission, PERMISSION_CODE);
            }
            else{
                //timersec = Integer.parseInt(mTimerSecinpt.getText().toString());
                timer = Integer.parseInt(mTimerSecinpt.getText().toString());
                startActivity(camera);
            }
        });
        BackButton = findViewById(R.id.back);
        BackButton.setOnClickListener(v ->{
            finish();
        });
    }
}
