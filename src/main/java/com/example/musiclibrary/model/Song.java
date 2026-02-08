package com.example.musiclibrary.model;

import jakarta.persistence.Entity;

@Entity
public class Song extends Media {

    private String artist;
    private String album;

    public Song() {
    }

    public Song(Long id, String title, String artist, String album) {
        this.id = id;
        setTitle(title);
        this.artist = artist;
        this.album = album;
    }

    public Song(String title, String artist, String album) {
        setTitle(title);
        this.artist = artist;
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
}
