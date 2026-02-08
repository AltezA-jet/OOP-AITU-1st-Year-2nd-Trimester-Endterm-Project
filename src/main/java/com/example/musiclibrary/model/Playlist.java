package main.java.com.example.musiclibrary.model;

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
    private List<Media> mediaList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    // Builder стартовая точка
    public static PlaylistBuilder builder() {
        return new PlaylistBuilder();
    }

    // Пакетный доступ — только Builder трогает
    void setName(String name) {
        this.name = name;
    }

    void addMedia(Media media) {
        this.mediaList.add(media);
    }
}
