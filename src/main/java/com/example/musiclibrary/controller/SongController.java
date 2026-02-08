package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService service;

    @GetMapping
    public List<Song> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Song create(@RequestBody Song song) {
        return service.save(song);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
