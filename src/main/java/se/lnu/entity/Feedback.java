package se.lnu.entity;

import javax.persistence.*;

@Entity
@Table
public class Feedback extends AbstractEntity {

    private String feedback;

    @ManyToOne
    @JoinColumn(name ="reviewer")
    private User reviewer;

    @ManyToOne
    @JoinColumn(name = "document")
    private Document document;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
