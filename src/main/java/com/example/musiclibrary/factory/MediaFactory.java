package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.Media;
import com.example.musiclibrary.model.Podcast;
import com.example.musiclibrary.model.Song;

public class MediaFactory {

    public static Media create(
            MediaType type,
            String title,
            String artist,
            String extra
    ) {
        return switch (type) {
            case SONG -> new Song(null, title, artist, extra);
            case PODCAST -> new Podcast(title, extra);
        };
    }
}
