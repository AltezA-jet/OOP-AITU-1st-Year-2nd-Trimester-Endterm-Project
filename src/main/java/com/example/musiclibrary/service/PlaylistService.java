package com.example.musiclibrary.service;

import com.example.musiclibrary.model.Media;
import com.example.musiclibrary.model.Playlist;
import com.example.musiclibrary.repository.MediaRepository;
import com.example.musiclibrary.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final MediaRepository mediaRepository;

    public PlaylistService(PlaylistRepository playlistRepository,
                           MediaRepository mediaRepository) {
        this.playlistRepository = playlistRepository;
        this.mediaRepository = mediaRepository;
    }

    public Playlist create(String name) {
        Playlist playlist = Playlist.builder()
                .name(name)
                .build();

        return playlistRepository.save(playlist);
    }

    public List<Playlist> getAll() {
        return playlistRepository.findAll();
    }

    public Playlist addMedia(Long playlistId, Long mediaId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow();

        Media media = mediaRepository.findById(mediaId)
                .orElseThrow();

        playlist.getMediaList().add(media);
        return playlistRepository.save(playlist);
    }
}
