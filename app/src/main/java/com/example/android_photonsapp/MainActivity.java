package com.example.android_photonsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android_photonsapp.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setup();
    }

    public void setup() {
        Button startMeasurements = findViewById(R.id.right_bottom_button_main);
        Button plantsData = findViewById(R.id.center_bottom_button_main);
        Button settings = findViewById(R.id.left_bottom_button_main);

        startMeasurements.setOnClickListener(v -> {
           Intent intent = new Intent(this, CameraActivity.class);
            startActivity(intent);
        });

        plantsData.setOnClickListener(v -> {
           Intent intent = new Intent(this, PlantActivity.class);
            startActivity(intent);
        });

    }
}
