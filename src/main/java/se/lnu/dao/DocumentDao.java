package se.lnu.dao;

import se.lnu.entity.Document;
import se.lnu.entity.Feedback;
import se.lnu.entity.User;

import java.util.List;


public interface DocumentDao {

    Document saveDocument(Document document);

    List<Document> viewAllDocuments();

    Feedback saveFeedback(Feedback feedback);

    Feedback viewFeedback(User user);

    Feedback viewFeedback(Document document);
}
