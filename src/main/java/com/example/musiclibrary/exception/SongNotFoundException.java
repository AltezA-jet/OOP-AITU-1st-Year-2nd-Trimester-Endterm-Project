package com.example.musiclibrary.exception;

public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException(Long id) {
        super("Song not found: " + id);
    }
}
