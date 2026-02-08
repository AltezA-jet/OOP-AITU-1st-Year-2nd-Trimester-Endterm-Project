package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.*;

public class MediaFactory {

    public static Media createMedia(MediaType type) {
        return switch (type) {
            case SONG -> new Song();
            case PODCAST -> new Podcast();
        };
    }
}
