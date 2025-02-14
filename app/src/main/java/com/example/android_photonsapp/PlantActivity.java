package com.example.android_photonsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlantActivity extends AppCompatActivity {

    private final ArrayList<PlantDataBaseFormat> plantArray = new ArrayList<>();
    private PlantDataBaseFormat plantDataBaseFormat;
    private PlantsAdapter plantsAdapter;
    private final int[] plantIndex = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_plants_activity);
        getTextPlants();
        recyclerViewSetup();
    }

    public void getTextPlants() {
        for (int i = 0; i < plantIndex.length; i++) {
            plantDataBaseFormat = PlantsInformation.getInstance().getPlant(plantIndex[i]);
            if (plantDataBaseFormat != null) {
                plantArray.add(plantDataBaseFormat);
            }
        }
    }

    public void recyclerViewSetup() {
        plantsAdapter = new PlantsAdapter(plantArray);
        RecyclerView rv = findViewById(R.id.recycler_layout_plant);
        rv.setAdapter(plantsAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
