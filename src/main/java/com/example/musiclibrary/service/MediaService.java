package com.example.musiclibrary.service;

import com.example.musiclibrary.factory.MediaFactory;
import com.example.musiclibrary.factory.MediaType;
import com.example.musiclibrary.model.Media;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaService {

    private final List<Media> mediaList = new ArrayList<>();

    public List<Media> getAll() {
        return mediaList;
    }

    public Media create(MediaType type, String title, String artist, String album) {
        Media media = MediaFactory.create(type, title, artist, album);
        mediaList.add(media);
        return media;
    }

    public void delete(Long id) {
        mediaList.removeIf(m -> m.getId().equals(id));
    }
}
