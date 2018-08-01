package com.ccss.nast.qrce.data;

import com.google.gson.annotations.SerializedName;

public class ApiObject {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    public ApiObject(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
