package com.example.android_photonsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class PlantsAdapter extends RecyclerView.Adapter<PlantsAdapter.PlantsAdapterViewHolder> {

    private final ArrayList<PlantDataBaseFormat> plantDataArrayList;

    public PlantsAdapter(ArrayList<PlantDataBaseFormat> plantArray) {
        this.plantDataArrayList = plantArray;
    }

    @NonNull
    @Override
    public PlantsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.fragment_plants_collections, parent, false); // ✅ FIX: Use correct item layout
        return new PlantsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantsAdapterViewHolder holder, int position) {
        PlantDataBaseFormat plants = plantDataArrayList.get(position);
        holder.bind(plants);
    }

    @Override
    public int getItemCount() {
        return plantDataArrayList.size();
    }

    static class PlantsAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView txt_1, txt_2, txt_3;

        public PlantsAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_1 = itemView.findViewById(R.id.plant_name);
            txt_2 = itemView.findViewById(R.id.text_1);
            txt_3 = itemView.findViewById(R.id.ideal_photon);
        }

        public void bind(PlantDataBaseFormat plant) {
            if (plant != null) { // ✅ Prevent potential null pointer issues
                txt_1.setText(plant.getText() != null ? plant.getText() : "N/A");
                txt_2.setText(plant.getA() != null ? plant.getA() : "N/A");
                txt_3.setText(plant.getB() != null ? plant.getB() : "N/A");
            }
        }
    }
}
