package se.lnu.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Document extends AbstractEntity {

    private String title;

    private String filePath;
  
    private String fileName;
    
    private String downloadURL;

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
