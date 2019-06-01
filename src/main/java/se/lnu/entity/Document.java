package se.lnu.entity;

import javax.persistence.*;

@Entity
@Table
public class Document extends AbstractEntity {

    private String title;

    @Column(name = "file_path")
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
