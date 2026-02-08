package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.Song;

public class MediaFactory {

    public static Song create(
            MediaType type,
            String title,
            String artist,
            String album
    ) {
        if (type != MediaType.SONG) {
            throw new IllegalArgumentException("Unsupported media type");
        }
        return new Song(null, title, artist, album);
    }
}
