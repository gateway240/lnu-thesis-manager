package se.lnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lnu.entity.Deadline;

@Repository("deadlineRepository")
public interface DeadlineRepository extends JpaRepository<Deadline, Integer> {

}
