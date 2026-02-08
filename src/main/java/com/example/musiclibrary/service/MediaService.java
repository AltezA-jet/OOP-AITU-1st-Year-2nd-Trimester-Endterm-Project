package com.example.musiclibrary.service;

import com.example.musiclibrary.factory.MediaFactory;
import com.example.musiclibrary.factory.MediaType;
import com.example.musiclibrary.model.Media;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

    public Media create(MediaType type, String title, String artist, String extra) {
        return MediaFactory.create(type, title, artist, extra);
    }
}
