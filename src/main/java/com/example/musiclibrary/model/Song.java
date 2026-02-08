package com.example.musiclibrary.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Song extends Media {

    private String artist;
    private String album;

    public Song(String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }
}
