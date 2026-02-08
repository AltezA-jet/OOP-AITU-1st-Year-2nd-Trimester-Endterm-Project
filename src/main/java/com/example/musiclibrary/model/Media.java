package com.example.musiclibrary.model;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String creator;

    protected Media() {
        // JPA
    }

    protected Media(String title, String creator) {
        this.title = title;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }
}
