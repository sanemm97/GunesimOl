package com.example.gunesimol;

import android.net.Uri;

import java.util.ArrayList;

public class Story {
    private int imageID;
    private String tittle, date;

    public int getImageID() {
        return this.imageID;
    }

    public String getTittle() {
        return this.tittle;
    }

    public String getDate() {
        return this.date;
    }

    public Story(int imageID, String tittle, String date)
    {
        this.imageID = imageID;
        this.tittle = tittle;
        this.date = date;
    }
    public Story()
    {

    }

}
