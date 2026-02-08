package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService service;

    public SongController(SongService service) {
        this.service = service;
    }

    @GetMapping
    public List<Song> getAll() {
        return service.getAllSongs();
    }

    @GetMapping("/{id}")
    public Song getById(@PathVariable Long id) {
        return service.getSongById(id);
    }

    @PostMapping
    public Song create(@RequestBody Song song) {
        return service.createSong(song);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSong(id);
    }
}
