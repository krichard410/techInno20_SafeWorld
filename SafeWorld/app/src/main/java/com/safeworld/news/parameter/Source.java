package com.safeworld.news.parameter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * The Article class use constructor each Source object
 * @author nieruize
 * @version 1.0
 */
public class Source {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    // get and set method
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
