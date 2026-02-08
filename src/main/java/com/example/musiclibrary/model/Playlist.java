package com.example.musiclibrary.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "playlist_media",
        joinColumns = @JoinColumn(name = "playlist_id"),
        inverseJoinColumns = @JoinColumn(name = "media_id")
    )
    private List<Media> mediaList = new ArrayList<>();

    // ОБЯЗАТЕЛЬНО для JPA
    protected Playlist() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    // Builder entry
    public static PlaylistBuilder builder() {
        return new PlaylistBuilder();
    }

    void setName(String name) {
        this.name = name;
    }

    void addMedia(Media media) {
        this.mediaList.add(media);
    }
}
