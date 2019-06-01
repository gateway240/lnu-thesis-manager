package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lnu.entity.Document;
import se.lnu.entity.User;

import javax.print.Doc;
import java.util.Collection;
import java.util.List;

@Repository("documentRepository")
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    @Query("select d from Document d WHERE d.author.username = :username")
    Collection<Document> findDocumentsByUsername(@Param("username") String username);
}
