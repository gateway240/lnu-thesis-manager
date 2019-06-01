package se.lnu.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.lnu.entity.Document;
import se.lnu.entity.Feedback;
import se.lnu.entity.User;
import se.lnu.repository.DocumentRepository;
import se.lnu.repository.FeedbackRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentDaoImpl implements DocumentDao {
    final static Logger LOG = LoggerFactory.getLogger(DocumentDaoImpl.class);
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
    public Collection<Document> getDocumentsByUsername(User user) {
        if( user != null && user.getUsername() != null){
            LOG.info("Username in getDocumentsByUsername: " + user.getUsername());
            return documentRepository.findDocumentsByUsername(user.getUsername());
        }
        else{
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional
    public Optional<Document> getDocumentById(Integer documentId) {
        return documentRepository.findById(documentId);
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
