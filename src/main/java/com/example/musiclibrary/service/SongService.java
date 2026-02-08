package com.example.musiclibrary.service;

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

    public Song updateSong(Long id, Song song) {
        Song existing = getSongById(id);

        existing.setTitle(song.getTitle());
        existing.setArtist(song.getArtist());
        existing.setAlbum(song.getAlbum());

        return songRepository.save(existing);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
