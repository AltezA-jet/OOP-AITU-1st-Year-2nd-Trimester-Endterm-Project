package com.example.musiclibrary.service;

import com.example.musiclibrary.dto.SongDto;
import com.example.musiclibrary.exception.SongNotFoundException;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song createSong(SongDto dto) {
        Song song = new Song(dto.getTitle(), dto.getArtist(), dto.getAlbum());
        return songRepository.save(song);
    }

    public Song updateSong(Long id, Song updated) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));

        song.setTitle(updated.getTitle());
        song.setArtist(updated.getArtist());
        song.setAlbum(updated.getAlbum());

        return songRepository.save(song);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
