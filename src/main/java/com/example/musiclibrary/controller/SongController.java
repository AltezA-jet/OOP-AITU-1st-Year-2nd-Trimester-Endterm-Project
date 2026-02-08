package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.repository.SongRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // GET /songs
    @GetMapping
    public Iterable<Song> getAllSongs() {
        return songRepository.findAll();
    }

    // POST /songs
    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songRepository.save(song);
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found"));
    }

    @PutMapping("/{id}")
    public Song updateSong(@PathVariable Long id, @RequestBody Song song) {
        Song existing = songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        existing.setTitle(song.getTitle());
        existing.setArtist(song.getArtist());
        existing.setAlbum(song.getAlbum());

        return songRepository.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songRepository.deleteById(id);
    }

    @PostMapping
        public Song createSong(@Valid @RequestBody Song song) {
        return songRepository.save(song);
    }
}
