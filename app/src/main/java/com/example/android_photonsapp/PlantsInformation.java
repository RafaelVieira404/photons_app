package com.example.android_photonsapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PlantsInformation implements Parcelable {
    private static final PlantsInformation instance = new PlantsInformation();
    private List<PlantDataBaseFormat> plantDataBaseFormatList;

    public PlantsInformation() {
        plantDataBaseFormatList = new ArrayList<>();
        plantDataBaseFormatList.add(new PlantDataBaseFormat(
                "Qual é o nome do ator que interpreta o pai de Sheldon, George Cooper Sr.?",
                "Lance Barber",
                "Jerry O'Connell",
                "Brian Posehn",
                "Keith Ferguson"));
    }


    public static PlantsInformation getInstance() {
        return instance;
    }

    protected PlantsInformation(Parcel in) {
        plantDataBaseFormatList = in.createTypedArrayList((Creator<PlantDataBaseFormat>) plantDataBaseFormatList);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeTypedList(plantDataBaseFormatList);

    }

    public static final Creator<PlantsInformation> CREATOR = new Creator<PlantsInformation>() {
        @Override
        public PlantsInformation createFromParcel(Parcel in) {
            return new PlantsInformation(in);
        }

        @Override
        public PlantsInformation[] newArray(int size) {
            return new PlantsInformation[size];
        }
    };

    public PlantDataBaseFormat getPlant(int aux) {
        return plantDataBaseFormatList.get(aux);
    }
}