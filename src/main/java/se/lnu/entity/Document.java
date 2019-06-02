package se.lnu.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Document extends AbstractEntity {

    private String title;

    @Column(name = "file_path")
    private String filePath;

    private String category;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "download_url")
    private String downloadURL;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "document")
    private List<Feedback> feedbackList;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {

        this.feedbackList = feedbackList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    @Override
    public String toString(){
        return "title : " + title + " filePath : " + filePath + " author : " + author + " fileName : " + fileName + " downloadURL : " + downloadURL;
    }
}
