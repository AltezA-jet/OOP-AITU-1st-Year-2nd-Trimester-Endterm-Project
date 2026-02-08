package com.example.musiclibrary.model;


import jakarta.persistence.Entity;

@Entity
public class Song extends Media {

    private String artist;
    private String album;

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
