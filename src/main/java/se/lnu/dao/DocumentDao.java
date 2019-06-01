package se.lnu.dao;

import se.lnu.entity.Document;
import se.lnu.entity.Feedback;
import se.lnu.entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface DocumentDao {

    Document saveDocument(Document document);

    List<Document> viewAllDocuments();

    Collection<Document> getDocumentsByUsername(User user);

    Optional<Document> getDocumentById(Integer documentId);

    Feedback saveFeedback(Feedback feedback);

    Feedback viewFeedback(User user);

    Feedback viewFeedback(Document document);
}
