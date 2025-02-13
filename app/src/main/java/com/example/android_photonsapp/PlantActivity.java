package com.example.android_photonsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlantActivity extends AppCompatActivity {


    private final ArrayList<PlantDataBaseFormat> plantArray = new ArrayList<>();
    private static PlantDataBaseFormat plantDataBaseFormat;
    private static PlantsAdapter plantsAdapter;
    private int[] plantIndex = {0,1,2,3,4,5,6,7,8,9};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_plants_activity);
    }

    public void getTextPlants() {
        for (int i = 0; i < 10; i += 1) {
           plantDataBaseFormat = PlantsInformation.getInstance().getPlant(plantIndex[i]);
           plantArray.add(plantDataBaseFormat);
        }
    }

    public void recyclerViewSetup(){
        plantsAdapter = new PlantsAdapter(plantArray);
        RecyclerView rv = findViewById(R.id.recycler_layout_plant);
        rv.setAdapter(plantsAdapter);
    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent Home = new Intent(this, MainActivity.class);
        startActivity(Home);
        finishAffinity();
    }
}
