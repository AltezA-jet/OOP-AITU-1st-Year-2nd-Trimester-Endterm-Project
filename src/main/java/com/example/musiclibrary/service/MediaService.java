package com.example.musiclibrary.service;

import com.example.musiclibrary.factory.MediaFactory;
import com.example.musiclibrary.factory.MediaType;
import com.example.musiclibrary.model.Media;
import com.example.musiclibrary.repository.MediaRepository;
import org.springframework.stereotype.Service;

@Service
public class MediaService {

    private final MediaRepository mediaRepository;

    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public Media create(MediaType type, String title, String artist, String album) {
        Media media = MediaFactory.create(type, title, artist, album);
        return mediaRepository.save(media);
    }

    public Iterable<Media> getAll() {
        return mediaRepository.findAll();
    }

    public void delete(Long id) {
        mediaRepository.deleteById(id);
    }
}
