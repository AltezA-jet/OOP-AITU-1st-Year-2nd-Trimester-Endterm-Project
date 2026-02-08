package com.example.musiclibrary.model;

import jakarta.persistence.Entity;

@Entity
public class Song extends Media {

    private String album;

    protected Song() {
        // JPA
    }

    public Song(String title, String artist, String album) {
        super(title, artist);
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }
}
