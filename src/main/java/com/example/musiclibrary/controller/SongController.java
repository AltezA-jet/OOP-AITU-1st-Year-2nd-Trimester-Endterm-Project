package com.example.musiclibrary.controller;

import com.example.musiclibrary.dto.SongDto;
import com.example.musiclibrary.model.Song;
import com.example.musiclibrary.service.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getAll() {
        return songService.getAllSongs();
    }

    @GetMapping("/{id}")
    public Song getById(@PathVariable Long id) {
        return songService.getSongById(id);
    }

    @PostMapping
    public Song create(@RequestBody Song song) {
        return songService.createSong(song);
    }

    @PutMapping("/{id}")
    public Song update(@PathVariable Long id, @RequestBody SongDto dto) {
        return songService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        songService.deleteSong(id);
    }
}
