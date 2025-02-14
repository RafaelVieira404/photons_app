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
                "Sunflower",
                "A tall plant known for its large, yellow flowers that turn towards the sun.",
                "1500 photons/day",
                "Requires full sunlight",
                "Prefers well-drained soil"));

        plantDataBaseFormatList.add(new PlantDataBaseFormat(
                "Cactus",
                "A drought-resistant plant that stores water in its thick stems.",
                "500 photons/day",
                "Thrives in arid conditions",
                "Requires minimal watering"));

        plantDataBaseFormatList.add(new PlantDataBaseFormat(
                "Bamboo",
                "A fast-growing grass species that can reach impressive heights.",
                "2000 photons/day",
                "Grows rapidly in moist conditions",
                "Used for construction and furniture"));

        plantDataBaseFormatList.add(new PlantDataBaseFormat(
                "Rose",
                "A flowering shrub known for its fragrant and colorful blossoms.",
                "1000 photons/day",
                "Needs regular pruning",
                "Commonly used in gardens and bouquets"));

        plantDataBaseFormatList.add(new PlantDataBaseFormat(
                "Fern",
                "A shade-loving plant that thrives in humid environments.",
                "700 photons/day",
                "Requires indirect sunlight",
                "Popular as an indoor decorative plant"));

        plantDataBaseFormatList.add(new PlantDataBaseFormat(
                "Lavender",
                "A fragrant herb used in aromatherapy and essential oils.",
                "1200 photons/day",
                "Prefers dry, well-drained soil",
                "Attracts bees and butterflies"));

        plantDataBaseFormatList.add(new PlantDataBaseFormat(
                "Tomato Plant",
                "A fruit-bearing plant commonly grown in home gardens.",
                "1800 photons/day",
                "Requires support for growth",
                "Needs consistent watering"));

        plantDataBaseFormatList.add(new PlantDataBaseFormat(
                "Maple Tree",
                "A deciduous tree known for its beautiful autumn foliage.",
                "2500 photons/day",
                "Produces maple syrup",
                "Requires deep soil and space"));

        plantDataBaseFormatList.add(new PlantDataBaseFormat(
                "Orchid",
                "A delicate and exotic flowering plant.",
                "900 photons/day",
                "Requires high humidity",
                "Often used as a decorative indoor plant"));

        plantDataBaseFormatList.add(new PlantDataBaseFormat(
                "Moss",
                "A small, non-vascular plant that thrives in damp environments.",
                "300 photons/day",
                "Does not require soil",
                "Commonly found in forests and gardens"));
    }

    public static PlantsInformation getInstance() {
        return instance;
    }

    protected PlantsInformation(Parcel in) {
        plantDataBaseFormatList = in.createTypedArrayList(PlantDataBaseFormat.CREATOR);
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
        if (aux >= 0 && aux < plantDataBaseFormatList.size()) {
            return plantDataBaseFormatList.get(aux);
        } else {
            return null; // Avoid IndexOutOfBoundsException
        }
    }
}
