package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.Podcast;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.model.Media;

public class MediaFactory {

    public static Media create(MediaType type, String title, String creator, String extra) {
        return switch (type) {
            case SONG -> new Song(title, creator, extra);
            case PODCAST -> new Podcast(title, creator);
        };
    }
}
