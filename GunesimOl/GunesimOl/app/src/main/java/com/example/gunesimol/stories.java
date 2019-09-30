package com.example.gunesimol;

import java.util.Date;

public class stories {
    private String storyId;
    private  String storyTittle;
    private String storyInput;
    private String storyDevelopment;
    private String storyResult;
    private String storyDate, storyClock;
    public stories(){


    }

    public stories(String storyId,String storyTittle ,String storyInput, String storyDevelopment, String storyResult, String storyDate, String storyClock) {
        this.storyId = storyId;
        this.storyTittle=storyTittle;
        this.storyInput = storyInput;
        this.storyDevelopment = storyDevelopment;
        this.storyResult = storyResult;
        this.storyDate= storyDate;
        this.storyClock=storyClock;
    }


    public String getstoryId() {
        return storyId ;
    }

    public void setstoryId(String storyId) {
        this.storyId = storyId;
    }
    public String getStoryTittle() {
        return storyTittle;
    }

    public void setStoryTittle(String storyTittle) {
        this.storyTittle = storyTittle;
    }
    public String getStoryInput() {
        return storyInput;
    }

    public void setStoryInput(String storyInput) {
        this.storyInput = storyInput;
    }
    public String getStoryDevelopment() {
        return storyDevelopment;
    }

    public void setStoryDevelopment(String storyDevelopment) {
        this.storyDevelopment = storyDevelopment;
    }
    public String getStoryResult() {
        return storyResult;
    }

    public void setStoryResult(String storyResult) {
        this.storyResult = storyResult;
    }
    public String getStoryDate() {
        return storyDate;
    }

    public void setStoryDate(String storyDate) {
        this.storyDate = storyDate;
    }
    public String getStoryClock() {
        return storyClock;
    }

    public void setStoryClock(String storyClock) {
        this.storyClock = storyClock;
    }


}
