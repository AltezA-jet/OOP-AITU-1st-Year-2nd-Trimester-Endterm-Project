package com.example.musiclibrary.service;

import com.example.musiclibrary.dto.SongDto;
import com.example.musiclibrary.exception.SongNotFoundException;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

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

    public Song updateSong(Long id, SongDto dto) {
        Song existing = getSongById(id);

        existing.setTitle(dto.getTitle());
        existing.setArtist(dto.getArtist());
        existing.setAlbum(dto.getAlbum());

        return songRepository.save(existing);
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }
}
