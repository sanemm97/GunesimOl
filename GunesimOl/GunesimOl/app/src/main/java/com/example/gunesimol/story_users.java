package com.example.gunesimol;

public class Story_users {
    private String userId;
    private String storyId;
    public Story_users(){

    }


    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }


    public Story_users(String userId, String storyId){

        this.userId = userId;
        this.storyId = storyId;

    }
}
