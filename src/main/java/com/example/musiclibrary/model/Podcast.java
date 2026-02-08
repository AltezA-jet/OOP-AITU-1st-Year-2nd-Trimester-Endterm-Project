package com.example.musiclibrary.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Podcast extends Media {

    private String host;

    public Podcast(String title, String host) {
        this.title = title;
        this.host = host;
    }
}
