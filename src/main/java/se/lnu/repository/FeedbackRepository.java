package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lnu.entity.Feedback;

@Repository("feedbackRepository")
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}
