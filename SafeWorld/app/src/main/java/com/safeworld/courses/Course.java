package com.safeworld.courses;

public class Course {

    private String title;
    private String description;
    private String img;
    private String url;

    public Course(String title, String description, String img, String url) {
        this.title = title;
        this.description = description;
        this.img = img;
        this.url = url;
    }

    // make sure to have an empty constructor inside ur model class
    public Course() {
    }

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
