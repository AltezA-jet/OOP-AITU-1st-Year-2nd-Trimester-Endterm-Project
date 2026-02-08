package com.example.musiclibrary.service;



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

    public List<Song> getAll() {
        return repository.findAll();
    }

    public Song save(Song song) {
        return repository.save(song);
    }
}
