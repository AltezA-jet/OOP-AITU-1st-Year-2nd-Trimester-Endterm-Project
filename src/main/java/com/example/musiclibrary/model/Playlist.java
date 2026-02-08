package com.example.musiclibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private List<Media> mediaList = new ArrayList<>();

    void setName(String name) {
        this.name = name;
    }

    void addMedia(Media media) {
        this.mediaList.add(media);
    }

    public static PlaylistBuilder builder() {
        return new PlaylistBuilder();
    }
}
