package com.example.android_photonsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlantActivity extends AppCompatActivity {


    private ArrayList<PlantDataBaseFormat> plantArray = new ArrayList<>();
    private PlantsAdapter plantsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.fragment_plants_activity);
        Intent intent = getIntent();
    }

    public void recyclerViewSetup(){
        plantsAdapter = new PlantsAdapter(plantArray);
        RecyclerView rv = findViewById(R.id.recycler_layout_plant);
        rv.setAdapter(plantsAdapter);
    }
}
