package com.example.musiclibrary.service;

import com.example.musiclibrary.dto.SongDto;
import com.example.musiclibrary.exception.SongNotFoundException;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return StreamSupport.stream(songRepository.findAll().spliterator(), false)
                .toList();
    }

    public Song getSongById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));
    }

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Song update(Long id, SongDto dto) {
        Song existing = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));

        Song updated = new Song(
                existing.getId(),
                dto.getTitle(),
                dto.getArtist(),
                dto.getAlbum()
        );

        return songRepository.save(updated);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
