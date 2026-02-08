package com.example.musiclibrary.controller;

import com.example.musiclibrary.dto.SongDto;
import com.example.musiclibrary.exception.SongNotFoundException;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.SongRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // GET /songs
    @GetMapping
    public List<SongDto> getAllSongs() {
        return StreamSupport.stream(songRepository.findAll().spliterator(), false)
                .map(song -> new SongDto(
                        song.getId(),
                        song.getTitle(),
                        song.getArtist(),
                        song.getAlbum()
                ))
                .toList();
    }

    // GET /songs/{id}
    @GetMapping("/{id}")
    public SongDto getSongById(@PathVariable Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));

        return new SongDto(
                song.getId(),
                song.getTitle(),
                song.getArtist(),
                song.getAlbum()
        );
    }

    // POST /songs
    @PostMapping
    public Song createSong(@Valid @RequestBody Song song) {
        return songRepository.save(song);
    }

    // PUT /songs/{id}
    @PutMapping("/{id}")
    public Song updateSong(@PathVariable Long id, @Valid @RequestBody Song song) {
        Song existing = songRepository.findById(id)
                .orElseThrow(() -> new SongNotFoundException(id));

        existing.setTitle(song.getTitle());
        existing.setArtist(song.getArtist());
        existing.setAlbum(song.getAlbum());

        return songRepository.save(existing);
    }

    // DELETE /songs/{id}
    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songRepository.deleteById(id);
    }
}
