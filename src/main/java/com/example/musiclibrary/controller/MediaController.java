package com.example.musiclibrary.controller;

import com.example.musiclibrary.factory.MediaType;
import com.example.musiclibrary.model.Media;
import com.example.musiclibrary.service.MediaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/media")
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @PostMapping
    public Media create(
            @RequestParam MediaType type,
            @RequestParam String title,
            @RequestParam String artist,
            @RequestParam(required = false) String album
    ) {
        return mediaService.create(type, title, artist, album);
    }

    @GetMapping
    public Iterable<Media> getAll() {
        return mediaService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mediaService.delete(id);
    }
}
