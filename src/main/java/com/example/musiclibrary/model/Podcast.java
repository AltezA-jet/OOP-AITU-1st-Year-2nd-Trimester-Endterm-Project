package com.example.musiclibrary.model;

import jakarta.persistence.Entity;

@Entity
public class Podcast extends Media {

    private String host;
    private int episodeNumber;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
}
