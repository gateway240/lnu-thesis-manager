package se.lnu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.lnu.entity.Document;
import se.lnu.entity.Feedback;
import se.lnu.entity.User;
import se.lnu.repository.DocumentRepository;
import se.lnu.repository.FeedbackRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DocumentDaoImpl implements DocumentDao {

    @Autowired
    @Qualifier("documentRepository")
    private DocumentRepository documentRepository;

    @Autowired
    @Qualifier("feedbackRepository")
    private FeedbackRepository feedbackRepository;

    @Override
    @Transactional
    public Document saveDocument(Document document) {

        return documentRepository.save(document);
    }


    @Override
    @Transactional
    public List<Document> viewAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    @Transactional
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    @Transactional
    public Feedback viewFeedback(User user) {
        return null;
//        return feedbackRepository
    }

    @Override
    @Transactional
    public Feedback viewFeedback(Document document) {
        return null;
    }
}
