package com.example.musiclibrary.dto;

public record SongDto(
        Long id,
        String title,
        String artist,
        String album
) {}
