package main.java.model.musiclibrary;

// import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "media")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column(name = "duration_seconds")
    private Integer durationSeconds; // Duration in seconds

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_size_mb")
    private Double fileSizeMB;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    // Конструктор
    protected Media() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }


    public abstract String getMediaType();
    
    public abstract String getCreator();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.updatedAt = LocalDate.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDate.now();
    }

    public Duration getDuration() {
        return durationSeconds != null ? Duration.ofSeconds(durationSeconds) : null;
    }

    public void setDuration(Duration duration) {
        this.durationSeconds = duration != null ? (int) duration.getSeconds() : null;
        this.updatedAt = LocalDate.now();
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
        this.updatedAt = LocalDate.now();
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        this.updatedAt = LocalDate.now();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        this.updatedAt = LocalDate.now();
    }

    public Double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(Double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
        this.updatedAt = LocalDate.now();
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Objects.equals(id, media.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", mediaType=" + getMediaType() +
                '}';
    }
}