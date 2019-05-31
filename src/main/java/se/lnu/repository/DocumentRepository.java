package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lnu.entity.Document;

@Repository("documentRepository")
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
