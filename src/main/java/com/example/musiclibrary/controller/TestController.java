package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class TestController {

    private final SongService service;

    public TestController(SongService service) {
        this.service = service;
    }

    @GetMapping
    public List<Song> getSongs() {
        return service.getAll();
    }

    @PostMapping
    public Song addSong(@RequestBody Song song) {
        return service.save(song);
    }
}
