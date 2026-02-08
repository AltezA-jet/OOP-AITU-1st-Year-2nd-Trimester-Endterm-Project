package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.*;

public class MediaFactory {

    public static Media create(MediaType type, String title, String artist, String album) {
        return switch (type) {
            case SONG -> new Song(title, artist, album);
            case PODCAST -> new Podcast(title, artist);
        };
    }
}
