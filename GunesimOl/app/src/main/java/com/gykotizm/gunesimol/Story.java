package com.gykotizm.gunesimol;



public class Story {
    private int imageID;
    private String tittle, date,storyId;

    public int getImageID() {
        return this.imageID;
    }

    public String getTittle() {
        return this.tittle;
    }

    public String getDate() {
        return this.date;
    }
    public String getStoryId() {
        return this.storyId;
    }

    public Story(int imageID, String tittle, String date, String storyId)
    {
        this.storyId=storyId;
        this.imageID = imageID;
        this.tittle = tittle;
        this.date = date;
    }
    public Story()
    {

    }

}
