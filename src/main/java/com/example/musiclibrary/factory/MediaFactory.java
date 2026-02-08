package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.*;

public class MediaFactory {

    public static Media create(
            MediaType type,
            String title,
            String creator,
            String extra
    ) {
        return switch (type) {
            case SONG -> new Song(title, creator, extra);
            case PODCAST -> new Podcast(title, creator);
        };
    }
}
