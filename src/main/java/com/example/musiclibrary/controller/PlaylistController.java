package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Playlist;
import com.example.musiclibrary.service.PlaylistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public Playlist create(@RequestParam String name) {
        return playlistService.create(name);
    }

    @GetMapping
    public List<Playlist> getAll() {
        return playlistService.getAll();
    }

    @PostMapping("/{playlistId}/media/{mediaId}")
    public Playlist addMedia(@PathVariable Long playlistId,
                             @PathVariable Long mediaId) {
        return playlistService.addMedia(playlistId, mediaId);
    }
}
