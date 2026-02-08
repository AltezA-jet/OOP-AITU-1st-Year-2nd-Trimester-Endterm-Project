package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.Media;

public class MediaFactory {

    public static Media create(MediaType type, String title, String artist, String album) {
        return new Media(type, title, artist, album);
    }
}
