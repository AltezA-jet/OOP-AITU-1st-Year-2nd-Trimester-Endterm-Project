package com.example.musiclibrary.factory;

import com.example.musiclibrary.model.Song;

public class MediaFactory {

    public static Song createSong(String title, String artist, String album) {
        return new Song(title, artist, album);
    }
}
