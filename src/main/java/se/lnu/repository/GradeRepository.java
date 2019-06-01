package se.lnu.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lnu.entity.Grade;

@Repository("gradeRepository")
public interface GradeRepository extends JpaRepository<Grade, Integer> {
	
}

