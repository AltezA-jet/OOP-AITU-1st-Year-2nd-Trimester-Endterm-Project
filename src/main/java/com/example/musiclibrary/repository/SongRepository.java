package com.example.musiclibrary.repository;

import com.example.musiclibrary.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
