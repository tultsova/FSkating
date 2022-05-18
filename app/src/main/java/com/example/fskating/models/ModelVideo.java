package com.example.fskating.models;


import androidx.annotation.NonNull;

public class ModelVideo {

    private Long id;
    private String name;
    private String URL;

    public ModelVideo(Long id, String name, String URL) {
        this.id = id;
        this.name = name;
        this.URL = URL;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
