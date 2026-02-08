package com.example.musiclibrary.model;

public class PlaylistBuilder {

    private final Playlist playlist = new Playlist();

    public PlaylistBuilder name(String name) {
        playlist.setName(name);
        return this;
    }

    public PlaylistBuilder add(Media media) {
        playlist.addMedia(media);
        return this;
    }

    public Playlist build() {
        return playlist;
    }
}
