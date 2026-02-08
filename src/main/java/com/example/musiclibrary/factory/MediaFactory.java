package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.Podcast;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.model.Media;

public class MediaFactory {

    public static Media create(MediaType type, String title, String artist, String albumOrHost) {
        return switch (type) {
            case SONG -> new Song(title, artist, albumOrHost);
            case PODCAST -> new Podcast(title, albumOrHost);
        };
    }
}
