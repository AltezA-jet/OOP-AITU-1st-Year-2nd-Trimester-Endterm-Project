package com.example.musiclibrary.service;

import com.example.musiclibrary.exception.SongNotFoundException;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository repository;

    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    public List<Song> getAllSongs() {
        return repository.findAll();
    }

    public Song getSongById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    public Song createSong(Song song) {
        return repository.save(song);
    }

    public void deleteSong(Long id) {
        repository.deleteById(id);
    }
}
