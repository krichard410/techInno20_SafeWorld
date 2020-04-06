package com.safeworld.courses;
/**
 * The Course class using for creating course object
 * @author nieruize
 * @version 1.0
 */
public class Course {

    // attribute
    private String title;
    private String description;
    private String img;
    private String url;

    // constructor
    public Course(String title, String description, String img, String url) {
        this.title = title;
        this.description = description;
        this.img = img;
        this.url = url;
    }

    // make sure to have an empty constructor inside ur model class
    public Course() {
    }

    // get and set method
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
