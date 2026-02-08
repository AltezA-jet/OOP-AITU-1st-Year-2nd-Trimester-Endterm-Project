package com.example.musiclibrary.model;

import jakarta.persistence.Entity;

@Entity
public class Podcast extends Media {

    private String host;

    public Podcast() {
    }

    public Podcast(String title, String host) {
        super(title);
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
