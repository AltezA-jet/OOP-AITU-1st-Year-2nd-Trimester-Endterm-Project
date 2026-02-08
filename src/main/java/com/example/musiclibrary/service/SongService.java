package com.example.musiclibrary.service;

import com.example.musiclibrary.exception.SongNotFoundException;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository repository;

    public List<Song> getAll() {
        return repository.findAll();
    }

    public Song getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    public Song save(Song song) {
        return repository.save(song);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
