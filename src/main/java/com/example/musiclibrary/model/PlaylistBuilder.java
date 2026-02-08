package main.java.com.example.musiclibrary.model;

public class PlaylistBuilder {

    private final Playlist playlist;

    public PlaylistBuilder() {
        this.playlist = new Playlist();
    }

    public PlaylistBuilder name(String name) {
        playlist.setName(name);
        return this;
    }

    public PlaylistBuilder addMedia(Media media) {
        playlist.addMedia(media);
        return this;
    }

    public Playlist build() {
        return playlist;
    }
}
