package com.example.musiclibrary.model;

import jakarta.persistence.Entity;

@Entity
public class Podcast extends Media {

    protected Podcast() {
        // JPA
    }

    public Podcast(String title, String host) {
        super(title, host);
    }
}
