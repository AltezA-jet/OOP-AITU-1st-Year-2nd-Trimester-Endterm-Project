package com.example.musiclibrary.builder;

import com.example.musiclibrary.model.Media;
import com.example.musiclibrary.model.Playlist;

public class PlaylistBuilder {

    private final Playlist playlist;

    public PlaylistBuilder() {
        this.playlist = new Playlist();
    }

    public PlaylistBuilder name(String name) {
        playlist.setName(name);
        return this;
    }

    public PlaylistBuilder addMedia(Media media) {
        playlist.addMedia(media);
        return this;
    }

    public Playlist build() {
        return playlist;
    }
}
