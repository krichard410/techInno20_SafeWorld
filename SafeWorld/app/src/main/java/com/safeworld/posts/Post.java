package com.safeworld.posts;


public class Post {

    private String title;
    private String description;
    private String userId;


    public Post(String title, String description, String userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    // make sure to have an empty constructor inside ur model class
    public Post() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
