package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lnu.entity.Submission;

@Repository("submissionRepository")
public interface SubmissionRepository extends JpaRepository<Submission,Integer> {
}
