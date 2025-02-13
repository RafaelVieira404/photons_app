package com.example.android_photonsapp;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


    class PlantsAdapter extends RecyclerView.Adapter<PlantsAdapter.PlantsAdapterViewHolder>{

    private final ArrayList<PlantDataBaseFormat> plantDataArrayList;

    public PlantsAdapter(ArrayList<PlantDataBaseFormat> plantArray) {
        this.plantDataArrayList = plantArray;
    }

    @NonNull
    @Override
    public PlantsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.fragment_plants_activity, parent, false);
        return new PlantsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantsAdapter holder, int position) {
        PlantDataBaseFormat plants  = plantDataArrayList.get(position);
        holder.bind(plants);
    }

    @Override
    public int getItemCount() {
       return plantDataArrayList.size();
    }

        class PlantsAdapterViewHolder extends RecyclerView.ViewHolder {


            public PlantsAdapterViewHolder(@NonNull View itemView) {
                super(itemView);

            }
        }

        public void bind(PlantDataBaseFormat question) {
            question_answer1.setText(question.getA());
            question_answer2.setText(question.getB());
            question_answer3.setText(question.getC());
            question_answer4.setText(question.getD());
        }