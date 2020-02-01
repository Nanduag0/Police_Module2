package com.example.policemodule.police;

import android.widget.ImageView;

public class Police_Info
{
    private int image;
    private String location,crime;

    public Police_Info(int image, String location, String crime) {
        this.image = image;
        this.location = location;
        this.crime = crime;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }
}
