package com.safeworld.posts;

/**
 * The Course class using for creating post object
 * @author nieruize
 * @version 1.0
 */
public class Post {

    // attribute
    private String title;
    private String description;
    private String userId;

    // constructor
    public Post(String title, String description, String userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

    // make sure to have an empty constructor inside ur model class
    public Post() {
    }

    // get and set method
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
