package com.example.android_photonsapp;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

public class PlantDataBaseFormat implements Parcelable {
    private final String Text;
    private final String a;
    private final String b;
    private final String c;
    private final String d;

    public PlantDataBaseFormat(String Text, String a, String b, String c, String d) {
        this.Text = Text;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected PlantDataBaseFormat(Parcel in) {
        Text = in.readString();
        a = in.readString();
        b = in.readString();
        c = in.readString();
        d = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Text);
        dest.writeString(a);
        dest.writeString(b);
        dest.writeString(c);
        dest.writeString(d);
    }

    public String getText() {
        return Text;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PlantDataBaseFormat> CREATOR = new Creator<PlantDataBaseFormat>() {
        @Override
        public PlantDataBaseFormat createFromParcel(Parcel in) {
            final PlantDataBaseFormat q = new PlantDataBaseFormat(
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readString(),
                    in.readString()
            );

            return q;
        }

        @Override
        public PlantDataBaseFormat[] newArray(int size) {
            return new PlantDataBaseFormat[size];
        }
    };
}